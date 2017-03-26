package com.com.demo02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by YR on 2015/7/28.
 */
public class Server02 {
    public static ArrayList<Socket> sockets = new ArrayList<>();
    public static void main(String args[]) throws IOException {

        ServerSocket ss = new ServerSocket(30000);
        while(true){
            Socket s = ss.accept();
            sockets.add(s);
            //启动一条新线程为客户端服务
            new Thread(

            ).start();
        }

    }

}
