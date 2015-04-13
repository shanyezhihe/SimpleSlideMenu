package com.example.loverecorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;




public class MainActivity extends Activity implements OnClickListener {
	private EditText username,password;
	private Button login;
	ImageButton stopMusic,startMusic;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.loginButton);
        login.setOnClickListener(this);
        stopMusic=(ImageButton)findViewById(R.id.stop);
        stopMusic.setOnClickListener(this);
        startMusic=(ImageButton) findViewById(R.id.play);
        startMusic.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View arg0) {
    	 Intent serviceIntent=new Intent(this,MusicService.class);
    if(arg0.getId()==R.id.loginButton){
		if(MainActivity.this.username.getText().toString().equals("LYL")&&MainActivity.this.password.getText().toString().equals("111059"))
		{	
			
			Intent activityIntent =new Intent(this,SlideActivity.class);
			startActivity(activityIntent);
		}
		else
		{
			MainActivity.this.finish();
		}}
    else if(arg0.getId()==R.id.play)
    {	Log.d("tag", "start¡À");
    	startService(serviceIntent);
    }
    else if(arg0.getId()==R.id.stop)
    {	Log.d("tag", "start¡À");
    	stopService(serviceIntent);
    }
    	
	}
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	
}
