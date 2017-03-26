package com.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;

public class MainActivity extends ActionBarActivity {
    private WebView webView;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        new HttpDemo("http://www.baidu.com",webView,handler).start();
    }
}
