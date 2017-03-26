package com.example.textcontextmenu;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showListViw();
	}
	//设置ListView的现实内容
	private void showListViw(){
		ListView listView =  (ListView) findViewById(R.id.listView);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, 
				getData());
		listView.setAdapter(adapter);
		this.registerForContextMenu(listView);
		
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("文件操作");
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.add(1,1,1,"复制");
		menu.add(1,2,1,"剪切");
		menu.add(1,3,1,"粘贴");
		menu.add(1,4,1,"删除");
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "点击了复制", Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(this, "点击了剪切", Toast.LENGTH_SHORT).show();
			break;
		case 3:
			Toast.makeText(this, "点击了粘贴", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(this, "点击了删除", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
	//构造ListView显示的数据
	private ArrayList<String> getData(){
		ArrayList<String> list = new ArrayList<>();
		for(int i = 1;i<=5;i++){
			list.add("文件"+i);
		}
		return list;
	}
}
