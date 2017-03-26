package com.demo02;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * Created by YR on 2015/5/30.
 *
 * 测试handler
 */
public class TestHandler extends Activity{
    private Handler  handler;
    private ImageView imageView;
    private int[] imageId = {R.drawable.meimei01,R.drawable.meimei02,R.drawable.meimei03,R.drawable.meimei04};
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_handler);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0x111)
                imageView = (ImageView) findViewById(R.id.image_handler);
               // imageView.setImageResource(imageId[count++%imageId.length]);
                imageView.setImageResource(R.drawable.meimei01);
            }
        };
        new Thread(){
            @Override
            public void run() {
                handler.sendEmptyMessage(0x111);
            }
        }.start();

       /* new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x111);
            }
        },0,1200);*/
    }
}
