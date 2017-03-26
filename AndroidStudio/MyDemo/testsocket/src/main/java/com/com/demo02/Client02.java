package com.com.demo02;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by YR on 2015/7/28.
 */
public class Client02 extends Activity {
    private EditText editText;
    private TextView tv;
    private Button button;

    Handler hander;
    //创建子线程
    ClientThread revThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo02);

        editText = (EditText) findViewById(R.id.edit_demo02);
        tv = (TextView) findViewById(R.id.tv_demo02);
        button = (Button) findViewById(R.id.btn_demo02);

        hander = new Handler() {
            @Override
            public void handleMessage(Message msg) {
               if(msg.what==0x123){
                   tv.append("\n"+msg.obj.toString());
               }
            }
        };
        revThread = new  ClientThread(hander);
        new Thread(revThread).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当用户按下发送按钮，发送消息
                Message msg = new Message();
                msg.what = 0x345;
                msg.obj = tv.getText().toString();
                revThread.revHandler.sendMessage(msg);
                //清空tv文本框
                tv.setText("");
            }
        });
    }
}
