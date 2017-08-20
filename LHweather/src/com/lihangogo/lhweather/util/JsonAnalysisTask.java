package com.lihangogo.lhweather.util;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lihangogo.lhweather.ObserverPattern.EventType;
import com.lihangogo.lhweather.ObserverPattern.Notify;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;

public class JsonAnalysisTask extends AsyncTask<String, Double, String> {
	private Context context;
	private QueryResultForWeatherFirst weather;
	
	public JsonAnalysisTask(Context context){
		this.context=context;
	}
	@Override
	protected String doInBackground(String... arg0) {
		String str=DataUtil.getWeather(context,arg0[0],arg0[1]);
		return str;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Gson gson=new GsonBuilder().create();			
		weather=gson.fromJson(result,QueryResultForWeatherFirst.class);
		//Log.e("weather",""+weather);
		operation();
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
	
	private void operation(){
		Notify.getInstance().NotifyActivity(EventType.UPDATE_MAIN);
	}

}
