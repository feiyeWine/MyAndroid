package com.example.testspinner;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private ArrayAdapter<String> adapter;
	private Spinner spinner;
	private List<String> list;
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testspinner);
		
		spinner = (Spinner) findViewById(R.id.spinner);
		text = (TextView) findViewById(R.id.text);
		//1、设置数据源
		list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		//2、新建适配器（ArrayAdapter）
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		//3、设置下拉列表
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//4、加载适配器
		spinner.setAdapter(adapter);
		
	}	
}
