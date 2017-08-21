package com.lihangogo.lhweather.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.lhweather.R;
import com.lihangogo.lhweather.ObserverPattern.BaseObserverActivity;
import com.lihangogo.lhweather.ObserverPattern.EventType;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;
import com.lihangogo.lhweather.util.JsonAnalysisTask;

public class MainActivity extends BaseObserverActivity {
	private JsonAnalysisTask task;
	private QueryResultForWeatherFirst weather;
	private String choosedCity = "CN101121003";
	private String spell = "zh";

	private LocationClient client=null;
	private BDLocationListener myListener=null;
	private String myCity="";
	private String myProvince="";
	private String myArea="";
	private String myCurrentLocation="";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 //theClear();

		//theInit();
		getLocation();
	}

	private void getLocation(){
		try{
		client=new LocationClient(getApplicationContext());
		initLocation();
		myListener=new MyLocationListener();
		client.registerLocationListener(myListener);
		
		client.start();
		client.requestLocation();
		}catch(Exception e){
			Log.e("aabb",""+e);
		}
	}
	
	private void initLocation(){
		LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("gcj02");//可选，默认gcj02，设置返回的定位结果坐标系
        //option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        client.setLocOption(option);
	}
	
	 public class MyLocationListener implements BDLocationListener {

	        @Override
	        public void onReceiveLocation(BDLocation location) {	            
	        	myCity = location.getCity(); 
	        	myProvince = location.getProvince();
	        	myArea = location.getDistrict();	
	        	Log.e("city",myCity+" "+myProvince+" "+myArea);
	        }
	    }
	
	/**
	 * 初始化
	 */
	private void theInit() {
		SharedPreferences sharedPreferences = getSharedPreferences("lhweather",
				Context.MODE_PRIVATE);
		int config = sharedPreferences.getInt("useNet", 2);
		Log.e("config", "1" + config);
		if (config == 2 || config == 0) {			
			judgeUseNet();
		} else if (config == 1) {			
			task = new JsonAnalysisTask(this);
			task.execute(choosedCity, spell);
		}
	}

	@Override
	protected void onChange(String eventType) {
		if (EventType.UPDATE_MAIN.equals(eventType)) {
			weather = task.getWeather();
			operation();
		}
	}

	@Override
	protected String[] getObserverEventType() {
		return new String[] { EventType.UPDATE_MAIN };
	}

	private void operation() {
		View view = findViewById(R.id.centerImg);
		AlphaAnimation aa = new AlphaAnimation(1, 0);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// Log.e("a2","a2");
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ChooseCityActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("weather1", weather);
				intent.putExtras(bundle);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});
	}

	/**
	 * 选择是否使用网络
	 */
	private void judgeUseNet() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			Log.e("ExceptionT", "whywhyT");
		}
		new AlertDialog.Builder(MainActivity.this)
				.setTitle("应用设置")
				.setMessage("亲~ 是否允许本应用使用网络？")
				.setPositiveButton("允许", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						writeIntoShared("useNet", 1);

						new AlertDialog.Builder(MainActivity.this)
								.setTitle("应用设置")
								.setMessage("亲~ 是否允许本应用使用您的SD卡？")
								.setPositiveButton("允许",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int which) {
												writeIntoShared("useSDCard", 1);	
												useLocationOrNot();
											}
										})
								.setNegativeButton("不允许",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int which) {
												writeIntoShared("useSDCard", 0);
												useLocationOrNot();
											}
										}).show();
						

					}
				})
				.setNegativeButton("不允许", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						writeIntoShared("useNet", 0);
						Toast.makeText(getApplicationContext(), "您会后悔的。。。",
								Toast.LENGTH_SHORT).show();
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							Log.e("Exception", "whywhy");
						}
						Intent intent = new Intent();
						intent.setClass(MainActivity.this, NoNetActivity.class);
						startActivity(intent);
					}
				}).show();
	}

	/**
	 * 是否允许使用定位功能
	 */
	private void useLocationOrNot(){
		new AlertDialog.Builder(MainActivity.this)
		.setTitle("应用设置")
		.setMessage("亲~ 是否允许本应用使用您的位置信息？")
		.setPositiveButton("允许",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface dialog,
							int which) {
						writeIntoShared("useLocation", 1);
						Toast.makeText(
								getApplicationContext(),
								"设置成功",
								Toast.LENGTH_SHORT)
								.show();
						
						task = new JsonAnalysisTask(
								MainActivity.this);
						task.execute(choosedCity, spell);
					}
				})
		.setNegativeButton("不允许",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface dialog,
							int which) {
						writeIntoShared("useLocation", 0);
						Toast.makeText(
								getApplicationContext(),
								"设置成功",
								Toast.LENGTH_SHORT)
								.show();
						
						task = new JsonAnalysisTask(
								MainActivity.this);
						task.execute(choosedCity, spell);
					}
				}).show();
	}
	
	/**
	 * 把设置写入xml文件
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	private void writeIntoShared(String key, int value) {
		SharedPreferences sp = getSharedPreferences("lhweather",
				Context.MODE_PRIVATE);
		Editor editor = sp.edit(); // 获取编辑器
		editor.putInt(key, value);
		editor.commit(); // 提交修改
	}

	private void writeIntoShared(String key, String value) {
		SharedPreferences sp = getSharedPreferences("lhweather",
				Context.MODE_PRIVATE);
		Editor editor = sp.edit(); // 获取编辑器
		editor.putString(key, value);
		editor.commit();
	}

	private void theClear() {
		writeIntoShared("useNet", 0);
		writeIntoShared("useSDCard", 0);
		writeIntoShared("useLocation", 0);
		writeIntoShared("subscribe", "");
	}
}
