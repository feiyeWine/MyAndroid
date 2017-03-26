package com.testSharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private EditText userName;
	private EditText userPassword;
	private CheckBox checkBox;
	private Button login;
	private Button logout;
	private Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		
		/*SharedPreferences pref = getSharedPreferences("message", 0);
		Editor editor = pref.edit();
		editor.putString("Mr Wang", "1234456");
		editor.putLong("long", System.currentTimeMillis());
		editor.putBoolean("default", true);
		editor.commit();
		editor.remove("default");
		editor.commit();*/
		userName = (EditText) findViewById(R.id.textView1);
		userPassword = (EditText) findViewById(R.id.textView2);
		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		login = (Button) findViewById(R.id.button1);
		logout = (Button) findViewById(R.id.button2);
		SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
		 editor = pref.edit();
		 String uname = pref.getString("userName", "");
		 if(uname==null){
			 checkBox.setChecked(false);
		 }else{
			 checkBox.setChecked(true);
			 userName.setText(uname);
		 }
		login.setOnClickListener(this);
		logout.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			String name = userName.getText().toString().trim();
			String pwd = userPassword.getText().toString().trim();
			if("admin".equals(name)&&"123456".equals(pwd)){
				if(checkBox.isChecked()){
					editor.putString("userName", name);
					editor.commit();
					Toast.makeText(MainActivity.this, "µÇÂ¼³É¹¦", Toast.LENGTH_SHORT).show();
				}else{
					editor.remove("userName");
					editor.commit();
				}
			}else{
				Toast.makeText(MainActivity.this, "½ûÖ¹µÇÂ¼", Toast.LENGTH_SHORT).show();

			}
			break;
		case R.id.button2:
			
			break;
		default:
			break;
		}
	}
}
