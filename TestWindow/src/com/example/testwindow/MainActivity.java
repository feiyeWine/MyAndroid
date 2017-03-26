package com.example.testwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//获取Activity中的window
		Window window = this.getWindow();
		//在标题栏上显示进度条
		this.setTitle("进度条...");
		//显示滚动条
		this.requestWindowFeature(Window.FEATURE_PROGRESS);
		//设置图标
		this.requestWindowFeature(Window.FEATURE_LEFT_ICON);
		/*//隐藏窗体状态栏
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//隐藏窗体上方标题栏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);*/
		setContentView(R.layout.activity_main);
		//设置进度条可见
		this.setProgressBarVisibility(true);
		this.setProgress(2000);
		this.setSecondaryProgress(6000);
		
		this.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.qq);
	}
}
