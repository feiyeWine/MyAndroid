package com.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 测试TestService
 * @author YR
 *
 */
public class ServiceExample extends Activity implements OnClickListener{
	private TextView textView;
	private Button button_start;
	private Button button_stop;
	private Button button_bind;
	private Button button_unbind;
	private TestService testService;
	private ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			//获取myBinder对象
			testService = ((TestService.MyBinder)service).getTestService();
			//显示系统日期
			textView.setText("time:"+testService.getSystemTime());
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service);
		
		textView = (TextView) findViewById(R.id.textView);
		button_start = (Button)findViewById(R.id.startService);
		button_stop = (Button)findViewById(R.id.stopService);
		button_bind = (Button)findViewById(R.id.bindService);
		button_unbind = (Button)findViewById(R.id.unbindService);
		button_start.setOnClickListener(this);
		button_stop.setOnClickListener(this);
		button_bind.setOnClickListener(this);
		button_unbind.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(ServiceExample.this, TestService.class);
		switch(v.getId()){
		case R.id.startService:
			startService(intent);
			break;
		case R.id.stopService:
			stopService(intent);
			break;
		case R.id.bindService:
			//连接应用服务
			bindService(intent, connection, BIND_AUTO_CREATE);
	break;
		case R.id.unbindService:
			unbindService(connection);
	break;
		}
	}
}
