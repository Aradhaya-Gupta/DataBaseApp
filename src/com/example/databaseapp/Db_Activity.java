package com.example.databaseapp;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Db_Activity {

	static final String Key_Rowid="id";
	static final String Key_Name="person_name";
	static final String Key_Dob="person_dob";
	static final String Database_name="person_db";
	static final String Database_Table="person_table";
	static final int Database_version=1;

	Dbhelper ourhelper;
	final Context ourContext;
	SQLiteDatabase ourdatabase;
	
	private static class Dbhelper extends SQLiteOpenHelper{

		public Dbhelper(Context context) {
			super(context, Database_name, null, Database_version);
		}
	
		
		@Override
		public void onCreate(SQLiteDatabase db) {
		
			db.execSQL ( "CREATE TABLE " + Database_Table + "(" +
			Key_Rowid + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			Key_Name + " TEXT NOT NULL,"+
			Key_Dob + " TEXT NOT NULL);");
					}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         
			db.execSQL("DROP TABLE IF EXISTS " + Database_Table);
                          onCreate(db);
         
		}
}
	
	public Db_Activity(Context c) {
		ourContext= c;
		
	}
	
	public Db_Activity open()
	
	{
	
		ourhelper = new Dbhelper(ourContext);
		ourdatabase= ourhelper.getWritableDatabase();
		return this;
		
	}

	public void close()
	
	{
		ourhelper.close();
	}
public long entry(String name,String dob)
{
	ContentValues cv=new ContentValues();
	cv.put(Key_Name, name);
	cv.put(Key_Dob, dob);
	return ourdatabase.insert(Database_Table, null, cv);
}

public void deleteRecord(Integer id) 
{
	// TODO Auto-generated method stub
		ourdatabase.delete(Database_Table, Key_Rowid+"="+ id, null);
}
public ArrayList<String> getAllId()
{
	String[] columns =new String[] {Key_Rowid};
	Cursor c=ourdatabase.query(Database_Table, columns, null,null,null,null,null);
	ArrayList<String> arr =new ArrayList<String>();
	for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
	{
		String str=c.getString(0);
				arr.add(str);
	}
	return arr;
	
}

public String getdata() {
	// TODO Auto-generated method stub
	String[] columns=new String[]{Key_Rowid,Key_Name,Key_Dob};
	Cursor c=ourdatabase.query( Database_Table, columns, null,null,null,null,null);
	String result="";
	Integer irow=c.getColumnIndex(Key_Rowid);
	Integer iname=c.getColumnIndex(Key_Name);
	Integer idob=c.getColumnIndex(Key_Dob);
	for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
	{
		result = result + c.getString(irow)+" "+c.getString(iname)+" "+c.getString(idob)+" \n";
	}
	return result;
}
public String getname(Integer id)
{
	String[] columns=new String[]{Key_Rowid,Key_Name,Key_Dob};
	Cursor c=ourdatabase.query(Database_Table, columns, Key_Rowid+" = "+id,null,null,null,null);
	String name=" ";
	if(c!=null)
	{
		c.moveToFirst();
		name=c.getString(1);
	}
	return name;
}
public String getdob(Integer id)
{
	String[] columns=new String[]{Key_Rowid,Key_Name,Key_Dob};
	Cursor c=ourdatabase.query(Database_Table, columns, Key_Rowid+" = "+id,null,null,null,null);
	String dob=" ";
	if(c!=null)
	{
		c.moveToFirst();
		dob=c.getString(2);
	}
	return dob;
	
}
public void updateRecord(Integer id,String name,String dob)
{
	ContentValues cv=new ContentValues();
	cv.put(Key_Name, name);
	cv.put(Key_Dob, dob);
	ourdatabase.update(Database_Table, cv, Key_Rowid+" = "+id, null);
}	
}
