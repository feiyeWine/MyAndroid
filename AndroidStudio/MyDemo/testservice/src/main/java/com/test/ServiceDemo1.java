package com.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by YR on 2015/7/2.
 */
public class ServiceDemo1 extends Service{
    private int count;//计数
    private boolean flag=true;//标记服务运行状态

    @Override
    public void onCreate() {
        super.onCreate();
        //打印log信息
        Log.i("ServiceDemo1","创建服务");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(flag) {
                    count++;
                }
            }
        }.start();
    }
    @Override
    public IBinder onBind(Intent intent) {

        //打印log信息
        Log.i("ServiceDemo1","绑定服务");
        MyBinder myBinder = new MyBinder();
        return myBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        //打印log信息
        Log.i("ServiceDemo1","取消绑定服务");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //该方法中执行耗时操作会导致ANR
        Log.i("ServiceDemo1","执行onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //打印log信息
        Log.i("ServiceDemo1","结束服务");
        super.onDestroy();
    }

    //创建自定义Binder
    private class MyBinder extends Binder{

        public int getCount(){

            return count;
        }
    }
}
