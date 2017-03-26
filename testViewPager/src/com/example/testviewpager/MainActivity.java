package com.example.testviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends Activity {

	private List<View> viewList;
	private ViewPager pager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_pager);
		//通过view对象去作为ViewPager的数据源
		View view1 = View.inflate(this, R.layout.view1, null);
		View view2 = View.inflate(this, R.layout.view2, null);
		View view3 = View.inflate(this, R.layout.view3, null);
		View view4 = View.inflate(this, R.layout.view4, null);
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		//创建PagerAdapter
		MyPagerAdapter adapter = new MyPagerAdapter(viewList);
		//viewPager加载适配器
		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
	}
}
