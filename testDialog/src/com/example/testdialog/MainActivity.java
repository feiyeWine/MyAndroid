package com.example.testdialog;

import java.util.zip.Inflater;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;
	private Button button2;
	private String[] str = {"男","女","博士","程序员"}; 
	private Button button3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		
	}
	//初始化
	private void init(){
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showDialog1();
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showDialog2();
			}
		});
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showDialog3();	
			}
		});
	}
	//确认按钮对话框
	private void showDialog1(){
		AlertDialog.Builder bulider = new AlertDialog.Builder(this);
		bulider.setTitle("确认对话框");	//设置标题
		bulider.setIcon(R.drawable.th_bossprefs2tv1);	//设置图标
		bulider.setMessage("确认对话框内容");	//设置内容
		bulider.setPositiveButton("确认", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this, "点击了确认对话框", Toast.LENGTH_SHORT).show();
			}
		});
		bulider.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
			}
		});
		//显示对话框
		AlertDialog dialog = bulider.create();
		dialog.show();
	}
	//单选按钮对话框
	private void showDialog2(){
		AlertDialog.Builder bulider = new AlertDialog.Builder(this);
		bulider.setTitle("单选对话框");	//设置标题
		bulider.setIcon(R.drawable.th_bossprefs2tv1);	//设置图标
		bulider.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				String text = str[arg1];
				Toast.makeText(MainActivity.this, "选择了"+text, Toast.LENGTH_SHORT).show();
			}
		});
		//显示对话框
		AlertDialog dialog = bulider.create();
		dialog.show();
	}
	/**
	 * 自定义对话框
	 */
	private void showDialog3(){
		LayoutInflater flater = LayoutInflater.from(this);
		View view = flater.inflate(R.layout.mydialog, null);
		AlertDialog.Builder bulider = new AlertDialog.Builder(this);
		bulider.setTitle("自定义对话框");
		bulider.setIcon(R.drawable.th_bossprefs2tv1);	//设置图标
		bulider.setView(view);
		
		//显示对话框
		AlertDialog dialog = bulider.create();
		dialog.show();
	}
}
