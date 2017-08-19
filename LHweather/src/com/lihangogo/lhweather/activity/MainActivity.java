package com.lihangogo.lhweather.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.example.lhweather.R;
import com.lihangogo.lhweather.ObserverPattern.BaseObserverActivity;
import com.lihangogo.lhweather.ObserverPattern.EventType;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;
import com.lihangogo.lhweather.util.JsonAnalysisTask;

public class MainActivity extends BaseObserverActivity {
	private JsonAnalysisTask task;
	private QueryResultForWeatherFirst weather;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		task=new JsonAnalysisTask(this);
		task.execute();
	}
	
	@Override
	protected void onChange(String eventType) {
		if(EventType.UPDATE_MAIN.equals(eventType)){
			weather=task.getWeather();
			Log.e("aa",weather.toString());
			operation();
		}
	}

	@Override
	protected String[] getObserverEventType() {
		return new String[]{
			EventType.UPDATE_MAIN	
		};
	}
	
	private void operation(){
		View view=findViewById(R.id.centerImg);
		AlphaAnimation aa=new AlphaAnimation(1, 0);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {	
			@Override
			public void onAnimationStart(Animation arg0) {	
				//Log.e("a2","a2");
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {	
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, WeatherActivity.class);
				Bundle bundle=new Bundle();
				bundle.putSerializable("weather", weather);
				intent.putExtras(bundle);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});
	}
	
}
