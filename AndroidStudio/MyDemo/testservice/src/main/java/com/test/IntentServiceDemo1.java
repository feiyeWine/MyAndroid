package com.test;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by YR on 2015/7/2.
 */
public class IntentServiceDemo1 extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentServiceDemo1(String name) {
        super(name);
    }
    public IntentServiceDemo1() {
        super("IntentServiceDemo1");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("IntentServiceDemo1","调用onHandleIntent方法");
        try {
            //让线程休眠20秒
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("IntentServiceDemo1","耗时操作执行完毕");
    }
}
