package com.com.demo02;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by YR on 2015/7/28.
 */
public class ClientThread implements Runnable {
    private Socket s;
    //向UI发送消息的handler
    Handler handler;
    //接收UI消息的handler
    Handler revHandler;
    BufferedReader br = null;
    OutputStream os = null;
    public ClientThread(Handler handler){
         this.handler = handler;
    }

    @Override
    public void run() {
        try {
            s = new Socket("10.0.2.2",30000);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = s.getOutputStream();
            //启动一条子线程来读取服务器响应数据
            new Thread(){
                @Override
                public void run() {
                    String content = null;
                    try {
                        while((content = br.readLine())!=null){
                            Message msg = new Message();
                            msg.what=0x123;
                            msg.obj = content;
                            handler.sendMessage(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            //初始化looper
            Looper.prepare();
            //创建revHandler对象
            revHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what ==0x345){
                        try {
                            os.write((msg.obj.toString() + "\r\n").getBytes("utf-8"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            Looper.loop();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
