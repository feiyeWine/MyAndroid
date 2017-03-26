package com.example.testprogressbar2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 测试进度条
 * @author YR
 *
 */
public class MainTest extends Activity{
	private ProgressBar progress;
	private TextView text;
	private Button button;
	private int count = 0;
	
	protected static final int STOP_FLAG = 0x100;
	protected static final int DOWNLOADING = 0x101;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_test);
		
		progress = (ProgressBar) findViewById(R.id.progressBar);
		text = (TextView) findViewById(R.id.text);
		button = (Button) findViewById(R.id.button);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				text.setText(R.string.start);
				progress.setVisibility(View.VISIBLE);
				progress.setMax(100);
				progress.setProgress(0);
				progress.setIndeterminate(false);
				
				new Thread(new Runnable(){

					@Override
					public void run() {
						while(count<100){
							count++;
							try {
								Thread.sleep(100);
								if(count==100){
									Message m = new Message();
									m.what = MainTest.STOP_FLAG;
									MainTest.this.handle.sendMessage(m);
									break;
								}else{
									Message m = new Message();
									m.what = MainTest.DOWNLOADING;
									handle.sendMessage(m);
								}
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
				}).start();
			}
		});
	}
	Handler handle = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case MainTest.STOP_FLAG:
				text.setText("下载完成");
				button.setText("下载完成");
				progress.setVisibility(View.GONE);
				Thread.currentThread().interrupt();
				break;
			case MainTest.DOWNLOADING:
				progress.setProgress(count);
				text.setText(getResources().getText(R.string.start)+Integer.toString(count)
						+"%\n"+"Progress:"+Integer.toString(progress.getProgress())
						);
				break;
			}
			super.handleMessage(msg);
		}
	};
}
