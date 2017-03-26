package com.demo01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.com.demo02.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * Created by YR on 2015/7/28.
 */
public class Client01 extends Activity {
    private EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo01);

        editText = (EditText) findViewById(R.id.edit_demo01);

        new Thread(){
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("192.168.1.192",30000);
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String line = br.readLine();
                    editText.setText("来自服务器的数据："+line);

                    br.close();
                    socket.close();
              } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
