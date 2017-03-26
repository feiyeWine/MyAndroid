package com.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by YR on 2015/7/2.
 */
public class BroadcastReceiverDemo03 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        int current = bundle.getInt("level");
        int total = bundle.getInt("scale");
        Log.i("BroadcastReceiver","手机电量:"+(current*1.0/total));
        Toast.makeText(context,"当前电量为："+(current*1.0/total),Toast.LENGTH_SHORT).show();
    }
}
