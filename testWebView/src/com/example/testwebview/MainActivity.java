package com.example.testwebview;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {
	private WebView webView;
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String url = "http://www.qq.com";
		/*Uri uri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);*/
		
		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl(url);
		webView.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				webView.loadUrl(url);
				return true;
			}
		});
		//在WebView中使用JavaScript
		//启用JavaScript
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		//优先使用缓存加载
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				if(newProgress == 100){
					//网页加载完毕，关闭ProgressDialog
					closeDialog();
					
				}else{
					//网页正在加载,打开ProgressDialog
					openDialog(newProgress);
				}
			}

			private void closeDialog() {
				if(dialog!=null&&dialog.isShowing()){
					dialog.dismiss();
					dialog = null;
				}
			}

			private void openDialog(int newProgress) {
				if(dialog==null){
					dialog = new ProgressDialog(MainActivity.this);
					dialog.setTitle("正在加载...");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.show();
				}else{
					dialog.setProgress(newProgress);
				}
			}
		});
	}
	//改写物理按键--返回的逻辑
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if(webView.canGoBack()){
				webView.goBack(); //返回上一页面
				return true;
			}
		
		else{
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
