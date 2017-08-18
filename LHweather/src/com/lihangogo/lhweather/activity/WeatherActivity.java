package com.lihangogo.lhweather.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.lhweather.R;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;

public class WeatherActivity extends Activity {
	private QueryResultForWeatherFirst weather;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		
		weather=(QueryResultForWeatherFirst) getIntent().getSerializableExtra("weather");
		//Log.e("bb",""+weather);
	}
	
}
