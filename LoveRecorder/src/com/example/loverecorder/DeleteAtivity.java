package com.example.loverecorder;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAtivity extends Activity implements OnClickListener {
	private Button delete_button;
	private EditText delete_edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		delete_button=(Button) findViewById(R.id.delete_button);
		delete_edit=(EditText) findViewById(R.id.delete_edit);
		delete_button.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		 SQLiteDatabase database=openOrCreateDatabase("Love.db",MODE_APPEND, null);
		 String del_edit=delete_edit.getText().toString();
		 Cursor cursor=null;
		 try{
		  cursor=database.query("mytab",new String[]{"_id"},"date=?", new String[]{del_edit},null,null,null);
		 if(cursor.moveToFirst())
		 {
		 database.delete("mytab", "date=?", new String[]{del_edit});
		 Toast.makeText(getApplicationContext(),"¹§Ï²Ã¶Ã¶£¬Êý¾ÝÉ¾³ý³É¹¦£¡", Toast.LENGTH_SHORT).show();
		 /* if(cursor.moveToFirst())
		 for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
		{  
		 String str=cursor.getString(cursor.getColumnIndex("date"));
		 database.execSQL("delete from mytab where (str=del_edit");
		Toast.makeText(getApplicationContext(),"¹§Ï²Ã¶Ã¶£¬Êý¾ÝÐ´Èë³É¹¦£¡", Toast.LENGTH_SHORT).show();
		}*/
	}}catch(Exception e){Toast.makeText(getApplicationContext(),"¹§Ï²Ã¶Ã¶£¬Êý¾ÝÉ¾³ýÊ§°Ü£¡", Toast.LENGTH_SHORT).show();}
		 }
	

}
