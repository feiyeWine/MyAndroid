package com.recorder.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.recorder.R;
import com.recorder.view.myAudioManager.AudioStateListener;

public class AudioRecorderButton extends Button implements AudioStateListener{
	private static final int DISTANCE_y_CANCEL = 50;
	private static final int STATE_NORMAL = 1;
	private static final int STATE_RECORDING = 2;
	private static final int STATE_WANT_TO_CANCEL = 3;
	private int mCurState  = STATE_NORMAL;
	//已经开始录音
	private boolean isRecording = false;
	
	private DialogManage mDialogManager;
	
	private myAudioManager mAudioManager;
	private float mTime;
	//是否触发longClick
	private boolean mReady;
	
	public AudioRecorderButton(Context context) {
		this(context,null);
	}

	public AudioRecorderButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		mDialogManager = new DialogManage(getContext());
		
		/*String dir = Environment.getExternalStorageDirectory()+"/my_recorder_audios";
		if(Environment.getExternalStorageDirectory().canWrite()){
			Log.i("recorder",Environment.getExternalStorageState().toString());
			Log.i("recorder", "外部存储不能写");
		}else{
			Log.i("recorder", "外部存储可以写");
		}*/
		String dir = "/storage/sdcard0/my_recorder_audios";
		
		mAudioManager = myAudioManager.getInstance(dir);
		mAudioManager.setOnAudioStateListener(this);
		setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				mReady = true;
				mAudioManager.prepareAudio();
				return false;
			}
		});
	}
	
	//录音完成后的回调
	public interface AudioFinishRecorderListener{
		void onFinish(float seconds,String filePath);
	}
	private AudioFinishRecorderListener mListener;
	
	public void setAudioFinishRecorderListener(AudioFinishRecorderListener listener){
		mListener = listener;
	}
	
	//获取音量大小的Runnable
	private Runnable mGetVoiceLevelRunnable = new Runnable() {
		
		@Override
		public void run() {
			while(isRecording){
				try {
					Thread.sleep(100);
					mTime += 0.1f;
					mHandler.sendEmptyMessage(MSG_VOICE_CHANGED);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private static final int MSG_AUDIO_PREPARED = 0x100;
	private static final int MSG_VOICE_CHANGED = 0x111;
	private static final int MSG_DIALOG_DIMISS = 0x112;
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MSG_AUDIO_PREPARED:
				//显示在audio end prepared之后
				mDialogManager.showRecordingDialog();
				isRecording = true;
				
				new Thread(mGetVoiceLevelRunnable).start();
				break;
			case MSG_VOICE_CHANGED:
				mDialogManager.updateVoiceLevel(mAudioManager.getVoiceLevel(7));
				break;
			case MSG_DIALOG_DIMISS:
				mDialogManager.dimissDialog();
				break;

			default:
				break;
			}
		};
	};
	
	@Override
	public void wellPrepared() {
		mHandler.sendEmptyMessage(MSG_AUDIO_PREPARED);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		int x = (int) event.getX();
		int y = (int) event.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			changeState(STATE_RECORDING);
			break;
		case MotionEvent.ACTION_MOVE:
			
			if(isRecording){
				if(wangToCancel(x,y)){
					changeState(STATE_WANT_TO_CANCEL);
				}else{
					changeState(STATE_RECORDING);
				}
			}
			break;
		case MotionEvent.ACTION_UP:
			if(!mReady){
				reset();
				return super.onTouchEvent(event);
			}if(!isRecording||mTime<0.6f){
				mDialogManager.toShort();
				mAudioManager.cancel();
				mHandler.sendEmptyMessageDelayed(MSG_DIALOG_DIMISS, 1300);
			}else if(mCurState == STATE_RECORDING){ //正常录制结束
				//release
				mDialogManager.dimissDialog();
				mAudioManager.release();
				//callbackToAct
				if(mListener!=null){
					mListener.onFinish(mTime, mAudioManager.getCurrentFilePath());
				}
				
				changeState(STATE_NORMAL);
			}else if(mCurState == STATE_WANT_TO_CANCEL){
				mDialogManager.dimissDialog();
				mAudioManager.cancel();
			}
			reset();
			break;

		default:
			break;
		}
		
		return super.onTouchEvent(event);
	}
	//恢复状态及标识位
	private void reset() {
		isRecording = false;
		mReady = false;
		mTime = 0;
		changeState(STATE_NORMAL);
	}

	private boolean wangToCancel(int x, int y) {
		if(x<0||x>getWidth()){
			return true;
		}
		if(y<-DISTANCE_y_CANCEL||y>getHeight()+DISTANCE_y_CANCEL){
			return true;
		}
		return false;
	}

	private void changeState(int state) {
		if(mCurState!=state){
			mCurState = state;
			switch (state) {
			case STATE_NORMAL:
				setBackgroundResource(R.drawable.btn_recorder_normal);
				setText(R.string.str_recorder_normal);
				break;
			case STATE_RECORDING:
				setBackgroundResource(R.drawable.btn_recording);
				setText(R.string.str_recorder_recording);
				if(isRecording){
					mDialogManager.recording();
				}
				break;
			case STATE_WANT_TO_CANCEL:
				setBackgroundResource(R.drawable.btn_recorder_normal);
				setText(R.string.str_recorder_want_cancel);
				mDialogManager.wantToCancel();
				break;

			default:
				break;
			}
		}
	}
}
