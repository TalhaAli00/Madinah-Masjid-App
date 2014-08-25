package com.example.madinahmasjid;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity
{
	private final int SPLASH_DISPLAY_LENGHT = 3000;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.splash);		
		
		/*
		 * New Handler to start the Menu-Activity and close this Splash-Screen after some seconds.
		 */
//		new Handler().postDelayed(new Runnable()
//		{
//			@Override
//			public void run()
//			{
//				/* Create an Intent that will start the Menu-Activity. */
//				Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
//				SplashScreen.this.startActivity(mainIntent);
//				SplashScreen.this.finish();
//			}
//		}, SPLASH_DISPLAY_LENGHT);
		new PrefetchData().execute();
	}
	
	private class PrefetchData extends AsyncTask<Void, Void, Void>
	{

		@Override
		protected Void doInBackground(Void... arg0)
		{
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Void... values)
		{
			super.onProgressUpdate(values);
		}
		
		@Override
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			
			new Handler().postDelayed(new Runnable()
			{
				@Override
				public void run()
				{
					Intent i = new Intent(SplashScreen.this, MainActivity.class);
					startActivity(i);
					finish();
				}
			}, SPLASH_DISPLAY_LENGHT);
			
//			Intent i = new Intent(SplashScreen.this, MainActivity.class);
//			startActivity(i);
			
//			finish();
		}
	}
}
