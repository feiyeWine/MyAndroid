package com.demo02;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by YR on 2015/5/30.
 */
public class TestLooper extends Activity {
    private LooperThread looperThread;
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_handler);
        textView  = (TextView) findViewById(R.id.tv_handler);
        imageView = (ImageView)findViewById(R.id.image_handler);
        imageView.setImageResource(R.drawable.meimei01);
        textView.setText("测试looper");
        looperThread = new LooperThread();
        looperThread.start();
    }
    class LooperThread extends  Thread{
        public Handler handler;
        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what == 0x001){
                        Toast.makeText(TestLooper.this,msg.getData().getString("looper"),Toast.LENGTH_LONG).show();
                       // textView.setText(msg.getData().getString("looper"));
                    }
                }
            };
            Looper.loop();
        }
    }
    public void setMsg( View v){
        Message msg = new Message();
        msg.what = 0x001;
        Bundle bundle = new Bundle();
        bundle.putString("looper","hello looper");
        msg.setData(bundle);
        textView.setText(msg.getData().getString("looper"));
        looperThread.handler.sendMessage(msg);
    }
}
