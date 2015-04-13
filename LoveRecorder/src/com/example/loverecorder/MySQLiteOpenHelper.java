package com.example.loverecorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	public MySQLiteOpenHelper(Context context, String name,
			 int version) {
		super(context, name,null,version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("tag", "helpercreate方法执行了!!!!!!!!!");
		System.out.print("fangfazhixingle ");
		String createMytab="create table mytab(_id integer primary key autoincrement,date varchar(30),address varchar(30),times varchar(10),recall varchar(255))";
		db.execSQL(createMytab);
		/*db.execSQL("create table hotel(_id integer primary key autoincrement,"
				+" name varchar(50),"
				+" sex varchar(10),"
				+" idCard varchar(50),"
				+" timeIn varchar(50),"
				+" timeSum varchar(50),"
				+" roomNum varchar(50),"
				+" money varchar(255))");
		db.execSQL("create table usertab( idCard varchar(50) ,"
				+" name varchar(50),"
				+" sex varchar(10))");
		db.execSQL("create table roomtab( roomNum varchar(50) ,"
				+" grade varchar(50),"
				+" price varchar(10))");
		db.execSQL("create table if not exists user(id integer primary key autoincrement,"
				+" username varchar(20),"
				+" pwd varchar(50))");*/
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
