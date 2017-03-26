package com.example.testoptionsmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.option_item, menu);
		//动态添加菜单
		menu.add(1,100,1,"菜单一");
		menu.add(1,101,1,"菜单二");
		menu.add(1,102,1,"菜单三");
		menu.add(1,103,1,"菜单四");
		menu.add(1,104,1,"菜单五");
		
		return true;
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case 100:
			Intent intent = new Intent(MainActivity.this, Menu1.class);
			item.setIntent(intent);
			startActivity(intent);
			break;
		case 101:
			Toast.makeText(MainActivity.this, "点击了菜单二", Toast.LENGTH_SHORT).show();
			break;
		case 102:
			Toast.makeText(MainActivity.this, "点击了菜单三", Toast.LENGTH_SHORT).show();
			break;
		case 103:
			Toast.makeText(MainActivity.this, "点击了菜单四", Toast.LENGTH_SHORT).show();
			break;
		case 104:
			Toast.makeText(MainActivity.this, "点击了菜单五", Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}
}
