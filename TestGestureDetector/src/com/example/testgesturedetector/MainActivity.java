package com.example.testgesturedetector;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	GestureDetector gesture;
	ImageView image;
	
	class MyGester extends SimpleOnGestureListener{
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if(e2.getX()-e1.getX()>30){
				Toast.makeText(MainActivity.this, "手指向右滑动", Toast.LENGTH_SHORT).show();
			}
			if(e2.getX()-e1.getX()<30){
				Toast.makeText(MainActivity.this, "手指向右左滑动", Toast.LENGTH_SHORT).show();
			}
			return super.onFling(e1, e2, velocityX, velocityY);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		image = (ImageView) findViewById(R.id.image);
		gesture = new GestureDetector(MainActivity.this,new MyGester());
		image.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				gesture.onTouchEvent(event);
				return true;
			}
		});
	}
}
