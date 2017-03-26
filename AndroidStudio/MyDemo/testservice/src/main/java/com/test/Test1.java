package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by YR on 2015/7/2.
 */
public class Test1 extends Activity implements View.OnClickListener {
    private Button btnStart1,btnStart2,btnStop1,btnStop2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_servicedemo1);

        //初始化按钮
        btnStart1 = (Button) findViewById(R.id.btn_ServiceDemo1_start);
        btnStart2= (Button) findViewById(R.id.btn_ServiceDemo1_stop);
        btnStop1 = (Button) findViewById(R.id.btn_IntentServiceDemo1_start);
        btnStop2 = (Button) findViewById(R.id.btn_IntentServiceDemo1_stop);
        //设置监听事件
        btnStart1.setOnClickListener(this);
        btnStart2.setOnClickListener(this);
        btnStop1.setOnClickListener(this);
        btnStop2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_ServiceDemo1_start:
                Toast.makeText(Test1.this,"启动ServiceDemo1",Toast.LENGTH_SHORT).show();
                intent.setClass(Test1.this, ServiceDemo1.class);
                startService(intent);
                break;
            case R.id.btn_ServiceDemo1_stop:
                Toast.makeText(Test1.this,"停止ServiceDemo1",Toast.LENGTH_SHORT).show();
                intent.setClass(Test1.this, ServiceDemo1.class);
                stopService(intent);
                break;
            case R.id.btn_IntentServiceDemo1_start:
                Toast.makeText(Test1.this,"启动IntentServiceDemo1",Toast.LENGTH_SHORT).show();
                intent.setClass(Test1.this, IntentServiceDemo1.class);
                startService(intent);
                break;
            case R.id.btn_IntentServiceDemo1_stop:
                Toast.makeText(Test1.this,"停止IntentServiceDemo1",Toast.LENGTH_SHORT).show();
                intent.setClass(Test1.this, IntentServiceDemo1.class);
                stopService(intent);
                break;
        }
    }
}
