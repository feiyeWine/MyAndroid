package com.example.testfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends ActionBarActivity implements OnCheckedChangeListener{
	private RadioGroup group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		group = (RadioGroup) findViewById(R.id.radioGroup1);
		group.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
			case R.id.first:{
				Intent intent = new Intent(this,Activity2.class);
				startActivity(intent);
				break;
			}
			case R.id.second:{
				MyFragment2 fragment2 = new MyFragment2();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
				beginTransaction.add(R.id.frame,fragment2);
				beginTransaction.addToBackStack(null);
				beginTransaction.commit();
				break;
			}
			case R.id.third:{
				
				break;
			}
			case R.id.four:{
				Intent intent = new Intent(this,Activity3.class);
				startActivity(intent);
				break;
			}
		}
	}
}
