package com.example.testfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment3 extends Fragment{
	private String code = "Thank you, Activity";
	public MyListener listener;
	public interface MyListener{
		public void thank(String code);
	}
	@Override
	public void onAttach(Activity activity) {
		listener = (MyListener) activity;
		super.onAttach(activity);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity2, container,false);
		TextView tv = (TextView) view.findViewById(R.id.text);
		String text = getArguments().get("name")+"";
		tv.setText(text);
		Toast.makeText(getActivity(), "已接收到数据"+text, Toast.LENGTH_SHORT).show();
		Toast.makeText(getActivity(), "向Activity发送"+code, Toast.LENGTH_SHORT).show();
		listener.thank(code);
		return view;
	}
}
