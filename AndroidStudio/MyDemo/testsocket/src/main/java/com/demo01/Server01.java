package com.demo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by YR on 2015/7/28.
 */
public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while(true){
            Socket s = ss.accept();
            OutputStream os = s.getOutputStream();
            os.write("hello,这是服务器的消息".getBytes("utf-8"));
            os.close();
            s.close();
        }
    }
}
