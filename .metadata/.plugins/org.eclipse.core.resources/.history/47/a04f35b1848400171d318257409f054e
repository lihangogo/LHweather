package com.lihangogo.lhweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.util.Log;

import com.example.lhweather.R;

public class DataUtil {
	private DataUtil(){
		
	}
	/**
	 * 获取天气信息
	 * @param context
	 * @param city 城市名称 可为拼音或代号
	 * @param lang 语言种类
	 * @return json串
	 */
	public static String getWeather(Context context,String city,String lang){
		StringBuilder response=null;
		String key=context.getString(R.string.key);		
		try {
			URL url=new URL("https://free-api.heweather.com/v5/weather?city="+city+"&key="
					+ key +"&lang="+lang);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(8000);
			connection.setReadTimeout(8000);
			connection.connect();				
			InputStream is=connection.getInputStream();
			BufferedReader reader=new BufferedReader(
					new InputStreamReader(is,"UTF-8"));
			response=new StringBuilder();
			String line;
			while((line=reader.readLine())!=null){
				response.append(line).append("\r\n");		
			}	
			reader.close();				
		} catch (Exception e) {
			Log.e("11","11");
		}
		return response.toString();
	}
	
	public static String getCity(){
		return null;
	}
}
