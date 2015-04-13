package com.example.loverecorder;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectAllActivity extends Activity implements OnClickListener {
	private TextView all_text;
	private Button allButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectall);
		all_text=(TextView) findViewById(R.id.all_text);
		all_text.setMovementMethod(ScrollingMovementMethod.getInstance());
		allButton=(Button)findViewById(R.id.all_button);
		allButton.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		 SQLiteDatabase database=openOrCreateDatabase("Love.db",MODE_APPEND, null);
		 Cursor cursor=database.query("mytab",new String[]{"date","address","times","recall"},null,null,null,null,null);
		 StringBuffer str=new StringBuffer();
		 if(cursor.moveToFirst())
		{
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
			{
				str.append("Date :"+cursor.getString(cursor.getColumnIndex("date"))
						+"\nAdderss :"+cursor.getString(cursor.getColumnIndex("address"))
						+"\nTimes :"+cursor.getString(cursor.getColumnIndex("times"))
						+"\n回忆 :"+cursor.getString(cursor.getColumnIndex("recall"))+"\n\n");
			}
			all_text.setText(str.toString());
			Toast.makeText(getApplicationContext(),"数据读取完毕！", Toast.LENGTH_SHORT).show();
		}
		 else{
			 all_text.setText("数据读取失败");
		 }
	}
	
}
