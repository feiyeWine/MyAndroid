package com.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by YR on 2015/7/2.
 */
public class BroadcastReceiverDemo02 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收广播
        Toast.makeText(context, "这是第二个BroadcastReceiver,接收到的Intent的Action为：" + intent.getAction() +
                        "消息内容 为：" + intent.getStringExtra("msg"), Toast.LENGTH_SHORT
        ).show();

        if(intent.getAction().equals("com.testBroadcastReceiverDemo2")){
            Toast.makeText(context, "取消广播发送", Toast.LENGTH_SHORT).show();
            Log.i("BroadcastReceiver", "取消广播发送");
           //abortBroadcast();//取消发送
        }
    }
}
