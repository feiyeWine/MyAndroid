package com.example.testsqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private final String dbName = "mydb";
	private final String tableName = "users";
	private SQLiteDatabase db = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		db = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
		String sql = "create table if not exists "+tableName+" (uname text,pwd integer)";
		db.execSQL(sql);
		Cursor c = db.rawQuery("select * from "+tableName, null);
		executeData();
		if(null!=c){
			while(c.moveToNext()){
				Log.i("info", "uname= "+c.getString(c.getColumnIndex("uname")));
				Log.i("info", "password= "+c.getInt(c.getColumnIndex("pwd")));
			}
		}
		c.close();
		//创建SQLite数据库
		/*SQLiteDatabase database = openOrCreateDatabase("myDatabase", MODE_PRIVATE, null);
		database.execSQL("create table if not exists user(_id integer primary key autoincrement,name text not null,age integer not null)");
		database.execSQL("insert into user(name,age) values('张三',20)");
		database.execSQL("insert into user(name,age) values('李四',21)");
		Cursor c = database.rawQuery("select * from user",null );
		if(null!=c){
			while(c.moveToNext()){
				Log.i("info", "_id:"+c.getInt(c.getColumnIndex("_id")));
				Log.i("info", c.getString(c.getColumnIndex("name")));
				Log.i("info","age:"+c.getInt(c.getColumnIndex("age")));
			}
			c.close();
		}
		database.close();*/
	}
	public void executeData(){
		String sql = "insert into "+tableName+" values('Mr huang','12345')";
		db.execSQL(sql);
		ContentValues cv = new ContentValues();	//实例化ContentValues对象
		cv.put("uname", "Mrs Li");
		cv.put("pwd", "666666");
		db.insert(tableName, null, cv);
		cv = new ContentValues();
		cv.put("pwd", "888888");
		db.update(tableName, cv, "uname=?", new String[]{"Mr huang"});
	}
}
