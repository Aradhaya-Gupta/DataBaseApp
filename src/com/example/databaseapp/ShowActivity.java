package com.example.databaseapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends Activity

{
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		tv=(TextView)findViewById(R.id.textView1);
		Db_Activity getRecord=new Db_Activity(getApplicationContext());
		getRecord.open();
		String str=getRecord.getdata();
		getRecord.close();
		tv.setText(str);
	}
}
