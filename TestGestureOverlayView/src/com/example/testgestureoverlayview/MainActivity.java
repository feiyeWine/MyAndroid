package com.example.testgestureoverlayview;

import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private GestureOverlayView gesture;
	private ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gesture = (GestureOverlayView)findViewById(R.id.gesture);
		image = (ImageView)findViewById(R.id.image);
		
		
	}

}
