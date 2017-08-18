package com.lihangogo.lhweather.util;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lihangogo.lhweather.ObserverPattern.EventType;
import com.lihangogo.lhweather.ObserverPattern.Notify;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;

public class JsonAnalysisTask extends AsyncTask<Integer, Double, String> {
	private Context context;
	private QueryResultForWeatherFirst weather;
	
	public JsonAnalysisTask(Context context){
		this.context=context;
	}
	@Override
	protected String doInBackground(Integer... arg0) {
		String str=DataUtil.getWeather(context,"beijing","zh");
		return str;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Gson gson=new GsonBuilder().create();			
		weather=gson.fromJson(result,QueryResultForWeatherFirst.class);
		opt1();
		//Log.e("wea",""+weather);
	}

	public QueryResultForWeatherFirst getWeather(){
		return weather;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Double... values) {
		super.onProgressUpdate(values);
	}
	
	private void opt1(){
		Notify.getInstance().NotifyActivity(EventType.UPDATE_MAIN);
	}
	/*
	private void opt(){
		View view=View.inflate(context, R.layout.activity_main, null);
		AlphaAnimation aa=new AlphaAnimation(0.1f, 0.1f);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {	
			@Override
			public void onAnimationStart(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				Intent intent=new Intent();
				intent.setClass(context, theActivity.class);
				startA
			}
		});
		

	}*/
}
