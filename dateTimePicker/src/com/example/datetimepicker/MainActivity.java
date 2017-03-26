package com.example.datetimepicker;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends ActionBarActivity {
	private TimePicker timePicker;
	private DatePicker datePicker;
	private Calendar cal;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datetime_picker);
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		setTitle(year+"-"+month+"-"+day+"  "+hour+":"+minute);
		
		datePicker = (DatePicker) findViewById(R.id.datePicker1);
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
		datePicker.init(year, cal.get(Calendar.MONTH), day, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
				setTitle(year+"-"+(month+1)+"-"+day);
			}
		});
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hour, int minute) {
				setTitle(hour+":"+minute);
			}
		});
		new DatePickerDialog(this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker datePicker, int year, int month, int day) {
				setTitle(year+"-"+(month+1)+"-"+day);				
			}
		}, year, cal.get(Calendar.MONTH), day).show();
		new TimePickerDialog(this, new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hour, int minute) {
				setTitle(hour+":"+minute);
			}
		}, hour, minute, true).show();
	}
}
