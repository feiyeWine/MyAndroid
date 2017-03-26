package com.myapplication;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView textView;
    Handler handler = new Handler();
    private ImageView imageView;
    private int index;
    private int image[] = {R.drawable.a,R.drawable.b,R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.image);

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("update UI Thread");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

       handler.postDelayed(myRunnable,1000);
    }
    private  MyRunnable myRunnable = new MyRunnable();
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            index++;
            index = index % 3;
            imageView.setImageResource(image[index]);
            handler.postDelayed(myRunnable,1000);
        }
    }
}
