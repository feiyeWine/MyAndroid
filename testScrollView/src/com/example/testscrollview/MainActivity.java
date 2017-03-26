package com.example.testscrollview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private TextView tv;
	private ScrollView scroll;
	private Button up_btn;
	private Button down_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//scrollView
		tv = (TextView) findViewById(R.id.content);
		tv.setText(getResources().getString(R.string.content));
		
		up_btn = (Button) findViewById(R.id.up);
		down_btn = (Button) findViewById(R.id.down);
		up_btn.setOnClickListener(this);
		down_btn.setOnClickListener(this);
		//监听
		scroll = (ScrollView) findViewById(R.id.scroll);
		scroll.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_MOVE:
				{
					/**
					 * getScrollY()--滚动条距离
					 * getMeasuredHeight()
					 * getHeight()
					 */
					//顶部状态
					
					if(scroll.getScrollY()<=0){
						Log.i("main","滑动到顶部");
					}
					//TextView的总高度 <= 屏幕的高度+滚动条滚动距离
					if(scroll.getChildAt(0).getMeasuredHeight()<=scroll.getHeight()+scroll.getScrollY()){
						Log.i("main", "滑动到底部");
						Log.i("main", "scroll.getChildAt(0).getMeasuredHeight()="+scroll.getHeight()+"scroll.getScrollY()="+scroll.getScrollY());
					}
					tv.append("这是新的一页");
					break;
				}
				}
				return false;
			}
		});
	
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.up:{
			scroll.scrollBy(0, -30);
			break;
		}
		case R.id.down:{
			scroll.scrollBy(0, 30);
			break;
		}
		}
	}
}
