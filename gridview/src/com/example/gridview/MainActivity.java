package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener{
	private GridView gridview;
	private SimpleAdapter adapter;
	List<Map<String,Object>> datalist;
	int[] icon = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f};
	String[] name = {"文件夹","加载","语音","搜索","按钮","点播"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Black_NoTitleBar);
		setContentView(R.layout.gridview);
		gridview = (GridView) findViewById(R.id.gridView1);
		datalist = new ArrayList<Map<String,Object>>();
		adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"image","text"},new int[]{R.id.imageView1,R.id.text});
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(this);
	}
	private List<Map<String,Object>> getData(){
		for(int i=0;i<icon.length;i++){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("image",icon[i]);
			map.put("text", name[i]);
			datalist.add(map);
		}
		return datalist;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Toast.makeText(this, "我是"+name[position],Toast.LENGTH_SHORT).show();
		
	}
}
