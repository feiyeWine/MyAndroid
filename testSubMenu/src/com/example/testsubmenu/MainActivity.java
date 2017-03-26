package com.example.testsubmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//通过XML文件加载子菜单
		MenuInflater inflater  = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		
	/*	//动态添加子菜单
		SubMenu file = menu.addSubMenu("文件");
		SubMenu edit = menu.addSubMenu("编辑");
		file.add(1,1,1,"新建");
		file.add(1,2,1,"打开");
		file.add(1,3,1,"保存");
		file.setHeaderTitle("文件操作");
		file.setHeaderIcon(R.drawable.ic_launcher);
		edit.add(2,1,1,"复制");
		edit.add(2,1,1,"粘贴");
		edit.add(2,1,1,"删除");
		edit.setHeaderTitle("编辑操作");*/
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.newFile:
			Toast.makeText(this, "点击了新建", Toast.LENGTH_SHORT).show();
			break;
		case R.id.openFile:
			Toast.makeText(this, "点击了打开", Toast.LENGTH_SHORT).show();
			break;
		case R.id.saveFile:
			Toast.makeText(this, "点击了新保存", Toast.LENGTH_SHORT).show();
			break;
		case R.id.editFile:
			Toast.makeText(this, "点击了复制", Toast.LENGTH_SHORT).show();
			break;
		case R.id.jianqieFile:
			Toast.makeText(this, "点击了粘贴", Toast.LENGTH_SHORT).show();
			break;
		case R.id.xiugaiFile:
			Toast.makeText(this, "点击了删除", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
		
	}
}
