package com.myapplication;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by YR on 2015/5/25.
 */
public class HttpDemo extends Thread{
    private String url;
    private WebView webView;
    private Handler handler ;
    public HttpDemo(String url, WebView webView, Handler handler){
        this.url = url;
        this.webView = webView;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            URL httpUrl = new URL(url);
            try {
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setReadTimeout(5000);
                conn.setRequestMethod("GET");
                final StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String  str;
                while((str = br.readLine())!=null){
                    sb.append(str);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadData(sb.toString(),"text/html;charset=utf-8",null);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
