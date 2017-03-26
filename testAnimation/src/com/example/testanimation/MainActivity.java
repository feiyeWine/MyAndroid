package com.example.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt_set;
	private ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1 = (Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		bt3 = (Button) findViewById(R.id.button3);
		bt4 = (Button) findViewById(R.id.button4);
		bt_set = (Button) findViewById(R.id.button_set);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt_set.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		image = (ImageView) findViewById(R.id.image);
		Animation animation = null;
		
		switch (v.getId()) {
		case R.id.button1:
			animation = getAlpha();
			break;
		case R.id.button2:
			animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);		
					break;
		case R.id.button3:
			animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
			break;
		case R.id.button4:
			animation = AnimationUtils.loadAnimation(this, R.anim.anim_ratate);
			break;
		case R.id.button_set:
			animation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
			break;

		default:
			break;
		}
		image.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				Toast.makeText(MainActivity.this, "动画开始了", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				Toast.makeText(MainActivity.this, "动画重播了", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				Toast.makeText(MainActivity.this, "动画结束了", Toast.LENGTH_SHORT).show();				
			}
		});
	}
	
	//动态加载动画
		private Animation getAlpha(){
			AlphaAnimation anim = new AlphaAnimation(1, 0);
			anim.setDuration(1000);
			anim.setFillAfter(false);
			anim.setRepeatCount(2);
			return anim;
		}
}
