package com.example.testcontentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ContentResolver cr = getContentResolver();
		//向联系人中插入一行数据
		ContentValues values = new ContentValues();
		Uri uri = cr.insert(RawContacts.CONTENT_URI, values);
		Long raw_contact_id = ContentUris.parseId(uri);
		values.clear();
		values.put(StructuredName.RAW_CONTACT_ID, raw_contact_id);
		values.put(StructuredName.DISPLAY_NAME, "张三");
		values.put(StructuredName.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
		uri = cr.insert(Data.CONTENT_URI, values);
		//插入电话信息
		values.clear();
		values.put(Phone.RAW_CONTACT_ID, raw_contact_id);
		values.put(Phone.NUMBER, "1666666");
		values.put(Phone.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
		uri = cr.insert(Data.CONTENT_URI, values);
		
/*		
		//系统中的查询
		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(Contacts.CONTENT_URI, new String[]{Contacts._ID,Contacts.DISPLAY_NAME}, null, null, null);
		if(c!=null){
			while(c.moveToNext()){
				int id = c.getInt(c.getColumnIndex(Contacts._ID));
				Log.i("info","_id:"+id);
				String name = c.getString(c.getColumnIndex(Contacts.DISPLAY_NAME));
				Log.i("info","dispaly_name:"+name);
				Cursor c1 = cr.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER,Phone.TYPE},
							Phone.CONTACT_ID+"="+id, null, null);
				if(c1!=null){
					while(c1.moveToNext()){
						int type = c1.getColumnIndex(Phone.TYPE);
						if(type==Phone.TYPE_HOME){
							Log.i("info","家庭电话:"+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
						}else if(type == Phone.TYPE_MOBILE){
							Log.i("info","手机号码:"+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
						}
					}
				}
				c1.close();
			}
		}
		c.close();
	*/
	}
}
