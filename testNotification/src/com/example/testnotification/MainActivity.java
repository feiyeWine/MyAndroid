package com.example.testnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	NotificationManager notiManager; //通知控制类
	int notifiId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		findViewById(R.id.send).setOnClickListener(this);
		findViewById(R.id.cancle).setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.send:
				sendNotification();
				break;
			case R.id.cancle:
				notiManager.cancel(notifiId);
				break;
		}
	}
	private void sendNotification(){
		Builder builder = new Notification.Builder(this);
		builder.setSmallIcon(R.drawable.icon); //设置图标
		builder.setTicker("Hello");	//手机状态的提示
		builder.setWhen(System.currentTimeMillis());
		builder.setContentTitle("我的通知栏"); //设置标题
		builder.setContentText("我来自通知栏"); //设置通知内容
		Intent intent = new Intent(this,MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);//点击后的意图
	/*	builder.setDefaults(Notification.DEFAULT_SOUND);//设置提示声音
		builder.setDefaults(Notification.DEFAULT_LIGHTS);//设置提示灯
		builder.setDefaults(Notification.DEFAULT_VIBRATE);//设置震动
*/		builder.setDefaults(Notification.DEFAULT_ALL);//
		Notification notification = builder.build();//4.1以上
		notiManager.notify(notifiId,notification);
	}
}
