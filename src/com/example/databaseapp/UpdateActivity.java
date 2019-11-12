package com.example.databaseapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends Activity
{
	Button btn1,btn2;
	EditText ed1,ed2,ed3;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		ed1=(EditText)findViewById(R.id.editText1);
		ed2=(EditText)findViewById(R.id.editText2);
		ed3=(EditText)findViewById(R.id.editText3);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Integer id=Integer.parseInt(ed1.getText().toString());
				Db_Activity record=new Db_Activity(getApplicationContext());
				record.open();
				String name=record.getname(id);
				String dob=record.getdob(id);
				record.close();
				ed2.setText(name);
				ed3.setText(dob);
				
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Integer id;
				String name,dob;
				id=Integer.parseInt(ed1.getText().toString());
				name=ed2.getText().toString();
				dob=ed3.getText().toString();
				Db_Activity update=new Db_Activity(getApplicationContext());
				update.open();
				update.updateRecord(id,name,dob);
				update.close();
			}
		});
	}
}
