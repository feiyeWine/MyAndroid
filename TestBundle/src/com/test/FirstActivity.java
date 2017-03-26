package com.test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity{
	private EditText myText;
	private Button myButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		
		myText = (EditText) findViewById(R.id.first_EditText);
		myButton = (Button) findViewById(R.id.first_button);
		myButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String str = myText.getText().toString();
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				intent.setClass(FirstActivity.this, Second.class);
				bundle.putString("message", str);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
