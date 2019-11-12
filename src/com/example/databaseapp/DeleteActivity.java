package com.example.databaseapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class DeleteActivity extends Activity
{
	Button btn1;
	Spinner sp1;
    Integer id;
	ArrayList<String> arr=new ArrayList<String>();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	 
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_delete);
    	btn1=(Button)findViewById(R.id.button1);
    	sp1=(Spinner)findViewById(R.id.spinner1);
    	Db_Activity bcd=new Db_Activity(getApplicationContext());
		bcd.open();
		arr=bcd.getAllId();
		bcd.close();
		ArrayAdapter<String> adap=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,arr);
		sp1.setAdapter(adap);
    	btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				id=Integer.parseInt(sp1.getSelectedItem().toString());
				Db_Activity abc=new Db_Activity(getApplicationContext());
				abc.open();
				abc.deleteRecord(id);
				abc.close();
				Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
				Intent w=new Intent(DeleteActivity.this,ShowActivity.class);
				startActivity(w);
				
				finish();
			}
		});
    }
}
