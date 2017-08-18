package com.lihangogo.lhweather.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;

/**
 * @author lihan
 */
public class JsonAnalysis {
	public Context context;
	public WeatherHandler handler;
	public QueryResultForWeatherFirst weather=null;
	
	public JsonAnalysis(Context context){
		this.context=context;
	}
	
	public QueryResultForWeatherFirst getWeather(String city,String lang){	
		handler=new WeatherHandler();
		WeatherThread theThread=new WeatherThread();
		new Thread(theThread).start();
		return weather;
	}
	class WeatherHandler extends Handler{
		
		public WeatherHandler() {
			super();
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			String str=(String)msg.obj;
			Gson gson=new GsonBuilder().create();			
			JsonAnalysis.this.weather=gson.fromJson(str,QueryResultForWeatherFirst.class);
			Log.e("bb",""+weather);
			//Intent intent=new Intent();
			//intent.setAction("com.lihangogo.lhweather.activity");
			//intent.put
			
		}	
	}
	class WeatherThread extends Thread{
		@Override
		public void run() {
			super.run();
			String str=DataUtil.getWeather(context,"beijing","zh");
			Message mss=new Message();
			mss.obj=str;
			JsonAnalysis.this.handler.sendMessage(mss);
		}
	}
}
