package com.lihangogo.lhweather.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lhweather.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;
import com.lihangogo.lhweather.util.DataUtil;
import com.lihangogo.lhweather.util.JsonAnalysis;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		JsonAnalysis analysis=new JsonAnalysis(MainActivity.this);
		QueryResultForWeatherFirst the=analysis.getWeather("beijing", "zh");
		Log.e("aa",""+the);
	}
}
