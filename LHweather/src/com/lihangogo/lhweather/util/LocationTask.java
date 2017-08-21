package com.lihangogo.lhweather.util;

import android.content.Context;
import android.os.AsyncTask;

public class LocationTask extends AsyncTask<String, Integer, String> {
	private Context context;
	private String city_id;
	
	public LocationTask(Context context){
		this.context=context;
	}
	
	public String getCityId(){
		return this.city_id;
	}
	
	@Override
	protected String doInBackground(String... arg0) {
		
		return null;
	}
	
	private void post() {
		

	}
	
	private void operation(){
		
	}
}
