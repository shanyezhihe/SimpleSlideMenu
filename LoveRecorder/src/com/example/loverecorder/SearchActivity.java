package com.example.loverecorder;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Contacts.Intents.Insert;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends Activity implements OnClickListener {
	private Button search_button;
	TextView search_date,search_address,search_times,search_alltimes,search_text;
	EditText search_editdate;
	
	 
  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		search_button=(Button) findViewById(R.id.search_button);
		search_editdate=(EditText) findViewById(R.id.search_editdate);
		search_date=(TextView) findViewById(R.id.search_date);
		search_address=(TextView) findViewById(R.id.search_address);
		search_times=(TextView) findViewById(R.id.search_times);
		search_alltimes=(TextView) findViewById(R.id.search_alltimes);
		search_text=(TextView) findViewById(R.id.search_text);
		search_button.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		 SQLiteDatabase database=openOrCreateDatabase("Love.db",MODE_APPEND, null);
		 String s=String.valueOf(database.isOpen());
		 Log.d("TAG", s);
		String search_edit=search_editdate.getText().toString();
		int alltimes=94;
		Log.d("TAG", "已经打开数据库");
		Cursor query=database.query("mytab", new String[]{"times"}, null, null, null, null, null);
		for(query.moveToFirst();!query.isAfterLast(); query.moveToNext())
		{
			alltimes+=Integer.parseInt(query.getString(query.getColumnIndex("times")));
			Log.d("TAG", String.valueOf(alltimes));
		}
		Cursor cursor=database.query("mytab",new String[]{"date","address","times","recall"},"date=?",new String[]{search_edit},null,null,null);
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
			{  
				
				//if((cursor.getString(cursor.getColumnIndex("date")))==(search_editdate.getText().toString()))
					Log.d("TAG", search_edit);
					search_date.setText(cursor.getString(cursor.getColumnIndex("date")));
					search_address.setText(cursor.getString(cursor.getColumnIndex("address")));
					search_times.setText(cursor.getString(cursor.getColumnIndex("times")));
					search_text.setText(cursor.getString(cursor.getColumnIndex("recall")));
					search_alltimes.setText(String.valueOf(alltimes));
			}
		
		
		if(database!=null&&database.isOpen())
		{
			database.close();
		}
	}
	

}
