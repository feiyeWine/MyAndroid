package com.example.testprogressbar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	private ProgressBar progressBar;
	private Button add;
	private Button reduce;
	private Button reset;
	private TextView text;
	private Button show;
	private ProgressDialog proDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//启用窗口进度条
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.progress_bar);
		//显示两种进度条
		setProgressBarVisibility(true);
		setProgressBarIndeterminate(true);
		setProgress(9999);
		init();
	}

	private void init() {
		add = (Button) findViewById(R.id.add);
		reduce = (Button) findViewById(R.id.reduce);
		reset = (Button) findViewById(R.id.reset);
		text = (TextView) findViewById(R.id.textView1);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		show = (Button) findViewById(R.id.show);
		int first = progressBar.getProgress();
		int second = progressBar.getSecondaryProgress();
		int max = progressBar.getMax();
		String str = "第一进度为："+(int)(first/(float)max*100)+"%"+"  第二进度为："+(int)(second/(float)max*100)+"%";
		text.setText(str);
		add.setOnClickListener(this);
		reduce.setOnClickListener(this);
		reset.setOnClickListener(this);
		show.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.add:{
			progressBar.incrementProgressBy(10);
			progressBar.incrementSecondaryProgressBy(10);
			break;
		}
		case R.id.reduce:{
			progressBar.incrementProgressBy(-10);
			progressBar.incrementSecondaryProgressBy(-10);
			break;
		}
		case R.id.reset:{
			progressBar.setProgress(80);
			progressBar.setSecondaryProgress(60);
			break;
		}
		case R.id.show:{
			//新建对话框
			proDialog = new ProgressDialog(MainActivity.this);
			//设置显示风格
			proDialog.setProgressStyle(proDialog.STYLE_HORIZONTAL);
			//设置标题
			proDialog.setTitle("my ProgressDialog");
			//设置对话框信息
			proDialog.setMessage("my progressDialog");
			//设置图片
			proDialog.setIcon(R.drawable.ic_launcher);
			/**
			 * 设置ProgressDialog的一些其他属性
			 */
			proDialog.setSecondaryProgress(40);
			proDialog.setMax(100);
			proDialog.incrementProgressBy(50);
			proDialog.setIndeterminate(false);
			
			//设置确定按钮
			proDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确认", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					Toast.makeText(MainActivity.this, "我是ProgressDialog", Toast.LENGTH_SHORT).show();
				}
			});
			//设置取消按钮
			proDialog.setCancelable(true);
			proDialog.show();
			break;
		}
		default:
			break;
		}
		String str = "第一进度为："+(int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"%"+"  第二进度为："+(int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%";
		text.setText(str);
	}
}
