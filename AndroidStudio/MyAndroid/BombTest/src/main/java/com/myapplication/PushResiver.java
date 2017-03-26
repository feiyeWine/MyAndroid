package com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import cn.bmob.push.PushConstants;

/**
 * Created by YR on 2015/5/2.
 */
public class PushResiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            String msg = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING);
            Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }
    }
}
