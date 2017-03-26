package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * ≤‚ ‘service
 * @author YR
 *
 */
public class TestService extends Service{
	private MyBinder binder = new MyBinder();
	@Override
	public IBinder onBind(Intent arg0) {
		System.out.println("start binder");
		return binder;
	}
	@Override
	public void onCreate() {
		System.out.println("start onCreate");
		super.onCreate();
	}
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		System.out.println("start onStart");
		super.onStart(intent, startId);
	}
	@Override
	public void onDestroy() {
		System.out.println("start onDestroy");
		super.onDestroy();
	}
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("start onUnbind");
		return super.onUnbind(intent);
	}
	public String getSystemTime(){
		Date time = new Date();
		SimpleDateFormat sTime = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		sTime.format(time);
		return time.toString();
		
	}
	public class MyBinder extends Binder{
		TestService getTestService(){
			return TestService.this;
		}
	}
}
