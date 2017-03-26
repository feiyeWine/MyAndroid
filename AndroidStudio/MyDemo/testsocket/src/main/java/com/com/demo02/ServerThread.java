package com.com.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by YR on 2015/7/28.
 */
public class ServerThread implements  Runnable {
    Socket s = null;
    BufferedReader br = null;
    public ServerThread(Socket s ) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
    }

    @Override
    public void run() {
        String content = null;
        //采用循环队列读取客户端数据
        while((content = readFromClient())!=null ){
            for(Socket s : Server02.sockets){
                try {
                    OutputStream os = s.getOutputStream();
                    os.write((content+"\n").getBytes("utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //读取客户端数据方法
    private String readFromClient(){
        try {
            return br.readLine();
        } catch (IOException e) {
            Server02.sockets.remove(s);//删除该socket
        }
        return null;
    }
}


























