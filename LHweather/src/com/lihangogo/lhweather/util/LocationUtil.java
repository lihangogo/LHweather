package com.lihangogo.lhweather.util;

import com.baidu.location.LocationClient;

import android.content.Context;

public class LocationUtil {
	private Context context;
	public LocationClient client=null;
	public String city="";
	String currentLocation="";
	
	
	public LocationUtil(Context context){
		this.context=context;
	}
	
	
}
