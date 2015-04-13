package com.example.loverecorder;



import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;

public class MusicService extends Service {
	private MediaPlayer mediaPlayer;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if (mediaPlayer==null)
		{
			mediaPlayer=MediaPlayer.create(this, R.raw.aa);
			mediaPlayer.setLooping(true);
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mediaPlayer.isPlaying())
		{
			mediaPlayer.stop();
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
				
					if(!mediaPlayer.isPlaying())
					{
						mediaPlayer.start();
					}
				
		return super.onStartCommand(intent, flags, startId);
	}

}
