package com.example.testprogressbar2;
/**
 * ≤‚ ‘handle
 */

/*
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView text;
	private int count = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text = (TextView) findViewById(R.id.text);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MyShedule(), 1, 6000);
	}
	private class MyShedule extends TimerTask{

		@Override
		public void run() {
			Message message = new Message();
			message.what = 1;
			handler.sendMessage(message);
		}
	}
	Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case 1:
				text.setText(new Integer(count).toString());
				count++;
				break;
			}
		}
	};
}
*/