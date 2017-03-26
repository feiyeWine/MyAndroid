package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by YR on 2015/7/2.
 */
public class SendBroadcastDemo1 extends Activity implements View.OnClickListener {
    private Button btnSend1,btnSend2 ,btnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sendbroadcastdemo1);

        btnSend1 = (Button) findViewById(R.id.btn_demo1_send);
        btnSend2 = (Button) findViewById(R.id.btn_demo01_sendOrder);
        btnGet = (Button) findViewById(R.id.btn_demo01_getLevel);

        btnSend1.setOnClickListener(this);
        btnSend2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_demo1_send:
                //发送普通广播
                intent.setAction("com.testBroadcastReceiverDemo1");
                intent.putExtra("msg","这是一条普通广播");
                sendBroadcast(intent);
                break;
            case R.id.btn_demo01_sendOrder:
                //发送有序广播
                intent.setAction("com.testBroadcastReceiverDemo2");
                intent.putExtra("msg","这是一条有序广播");
                sendOrderedBroadcast(intent,null);
                break;
            case R.id.btn_demo01_getLevel:
                intent.setAction("android.intent.action.BATTERY_CHANGED");
                sendBroadcast(intent);
        }
    }
}
