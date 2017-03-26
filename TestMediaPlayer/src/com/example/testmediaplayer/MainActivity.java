package com.example.testmediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	private Button bt_start;
	private Button bt_pause;
	private Button bt_stop;
	private MediaPlayer mediaPlayer = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_start = (Button)findViewById(R.id.start);
		bt_pause = (Button)findViewById(R.id.pause);
		bt_stop = (Button) findViewById(R.id.stop);
		//添加点击事件
		bt_start.setOnClickListener(this);
		bt_pause.setOnClickListener(this);
		bt_stop.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.start:
			start();
			break;
		case R.id.pause:
			pause();
			break;
		case R.id.stop:
			stop();
			break;
		}
	}
	public void start(){
		try {
			if(mediaPlayer != null){
				if(mediaPlayer.isPlaying()){	//是否正在播放
					return;
				}
			}
			stop();	//调用停止播放方法
			mediaPlayer = MediaPlayer.create(this, R.raw.chong_xin_lai_guo); //加载MP3文件
			//文件播放完毕监听事件
			mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer arg0) {
					//覆盖文件播出完毕事件
					//解除资源与MediaPlayer的赋值关系，让资源可以为其他程序利用
					mediaPlayer.release();
					bt_start.setText("播放");
				}
			});
			//文件播放错误监听
			mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
				
				@Override
				public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
					mediaPlayer.release();
					return false;
				}
			});
			//开始播放
			mediaPlayer.start();
			bt_start.setText("正在播放");
			bt_pause.setText("暂停");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pause(){
		try {
			if( mediaPlayer != null ){
				if(mediaPlayer.isPlaying()){
					mediaPlayer.pause();
					bt_pause.setText("取消暂停");
				}else{
					mediaPlayer.start();
					bt_pause.setText("暂停");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stop(){
		try {
			if(mediaPlayer != null){
				mediaPlayer.stop();
				bt_start.setText("播放");
				bt_pause.setText("暂停");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
