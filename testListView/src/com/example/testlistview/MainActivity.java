package com.example.testlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnScrollListener
{
	private ListView listView;
	private ArrayAdapter<String> arr_adapter;
	private SimpleAdapter sim_adapter;
	private List<Map<String,Object>> dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter);
		
		listView = (ListView) findViewById(R.id.listView1);
		//1、新建一个适配器
		//ArrayAdapter(上下文，当前ListView所加载的每一个列表对应的布局文件);
		//SimpAdapter()
		/*
		 * context：上下文
		 * data:数据源（List<? extends Map<String,?> data>）一个Map所组成的List集合
		 * 			每一个Map都会去对应ListView列表中的一行
		 * 			每一个Map（键-值对）中的键必须包含所有在from中所指定的键
		 * resource：列表项的布局文件ID
		 * from:Map中的键名
		 * to:绑定数据视图中的ID，与from成对应关系
		 */
		//2、适配器加载数据源
		//String[] arr_data = {"data1","data2","data3","data4"};
		dataList = new ArrayList<Map<String,Object>>();
		sim_adapter = new SimpleAdapter(this, getData(), R.layout.simple_list, new String[]{"item1","item2"},new int[]{R.id.img1,R.id.text1} );
		//arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
		//3、（ListView）加载适配器
		//listView.setAdapter(arr_adapter);
		listView.setAdapter(sim_adapter);
		listView.setOnItemClickListener(this);
		listView.setOnScrollListener(this);
	}
	private List<Map<String,Object>> getData(){
		for(int i = 0 ;i < 20;i++){
			Map<String,Object>map = new HashMap<>();
			map.put("item1", R.drawable.ic_launcher);
			map.put("item2", "item"+i);
			dataList.add(map);
		}
		return dataList;
	}
	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		
	}
	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		switch(arg1){
			case SCROLL_STATE_FLING:
				Log.i("main","手指在离开屏幕时用力滑了下，视图通过惯性继续滑动");
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("item1", R.drawable.ic_launcher);
				map.put("item2","新增项");
				dataList.add(map);
				sim_adapter.notifyDataSetChanged();
				break;
			case SCROLL_STATE_IDLE:
				Log.i("main","视图已经停止滑动");
			case SCROLL_STATE_TOUCH_SCROLL:
				Log.i("main","手指没有离开屏幕，视图正在滑动");
		
		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		String text = listView.getItemAtPosition(arg2)+"";
		Toast.makeText(this, "position="+arg2+"text="+text, Toast.LENGTH_SHORT).show();
	}
}
