package com.example.testgallery;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.Gallery;
import android.widget.ImageSwitcher;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener,ViewFactory{
	//准备数据源
	private int[] res = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
	private Gallery gallery;
	private ImageSwitcher is;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = (Gallery) findViewById(R.id.gallery);
		is = (ImageSwitcher) findViewById(R.id.is);
		ImageAdapter adapter = new ImageAdapter(res, this);
		//加载适配器
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(this);
		is.setFactory(this);
		is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		is.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		is.setBackgroundResource(res[position%res.length]);
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public View makeView() {
		ImageView image = new ImageView(this);
		image.setScaleType(ScaleType.FIT_CENTER);
		
		return image;
	}
}
