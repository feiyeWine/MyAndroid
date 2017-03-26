package com.example.dg;

import android.support.v7.app.ActionBarActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
	}
	/**
	 * 监听屏幕旋转
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		//获取屏幕当前状态
		if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){ //Configuration.ORIENTATION_PORTRAIT表示竖屏
			Toast.makeText(MainActivity.this, "现在是竖屏", Toast.LENGTH_SHORT).show();
		}
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){//Configuration.ORIENTATION_LANDSCAPE表示横屏
			Toast.makeText(MainActivity.this, "现在是横屏", Toast.LENGTH_SHORT).show();

		}
		
		super.onConfigurationChanged(newConfig);
	}
}
