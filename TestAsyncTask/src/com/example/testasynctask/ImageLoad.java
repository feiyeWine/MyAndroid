package com.example.testasynctask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ImageLoad extends Activity{
	private ImageView image;
	private ProgressBar progressBar;
	private static String URL = "http://img.my.csdn.net/uploads/201504/12/1428806103_9476.png";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image = (ImageView) findViewById(R.id.image);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		
		//设置传递进去的参数
		new MyAsyncTask().execute(URL);
	}
	class MyAsyncTask extends AsyncTask<String, Void, Bitmap>{

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressBar.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			
			progressBar.setVisibility(View.GONE);
			image.setImageBitmap(result);
			
		}
		
		@Override
		protected Bitmap doInBackground(String... params) {
			//获取传递进来的参数
			String url = params[0];
			Bitmap bitmap = null;
			URLConnection conn;
			InputStream is;
			try {
				conn  = new URL(url).openConnection();
				is = conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				Thread.sleep(3000);
				//解析输入流
				bitmap = BitmapFactory.decodeStream(bis);
				is.close();
				bis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return bitmap;
		}
	}
}
