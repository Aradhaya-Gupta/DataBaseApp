package com.example.databaseapp;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ed1,ed2;
	Button btn1,btn2,btn3,btn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed1=(EditText)findViewById(R.id.editText1);
		ed2=(EditText)findViewById(R.id.editText2);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn4=(Button)findViewById(R.id.button4);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String nm,dob;
				// TODO Auto-generated method stub
				nm=ed1.getText().toString();
				dob=ed2.getText().toString();
				Db_Activity ins=new Db_Activity(getApplicationContext());
				ins.open();
				ins.entry(nm, dob);
				ins.close();
				Toast.makeText(getApplicationContext(), "Record saved", Toast.LENGTH_SHORT).show();
				ed1.setText("");
				ed2.setText("");
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent iu=new Intent(MainActivity.this,ShowActivity.class);
				startActivity(iu);
				
			}
		});
		btn3.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent u=new Intent(MainActivity.this,DeleteActivity.class);
				startActivity(u);
				
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent re=new Intent(MainActivity.this,UpdateActivity.class);
				startActivity(re);
			}
		});
	}
}