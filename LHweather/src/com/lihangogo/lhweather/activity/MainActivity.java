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

import com.example.lhweather.R;
import com.lihangogo.lhweather.ObserverPattern.BaseObserverActivity;
import com.lihangogo.lhweather.ObserverPattern.EventType;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;
import com.lihangogo.lhweather.util.JsonAnalysisTask;

public class MainActivity extends BaseObserverActivity {
	private JsonAnalysisTask task;
	private QueryResultForWeatherFirst weather;
	private String choosedCity="CN101121003";
	private String spell="zh";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//theClear();
			
		theInit();
	}
	
	/**
	 * 初始化
	 */
	private void theInit(){
		SharedPreferences sharedPreferences = getSharedPreferences("lhweather",
				Context.MODE_PRIVATE);
		int config = sharedPreferences.getInt("useNet", 2);
		Log.e("config", "1" + config);
		if (config == 2 || config == 0) {
			// 弹窗给选择
			judgeUseNet();
		} else if (config == 1) {
			// 可以继续执行正常代码
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
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			Log.e("ExceptionT","whywhyT");
		}
		new AlertDialog.Builder(MainActivity.this).setTitle("应用设置")
				.setMessage("亲~ 是否允许本应用使用网络？")
				.setPositiveButton("允许", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						writeIntoShared("useNet", 1);
						
						
						new AlertDialog.Builder(MainActivity.this).setTitle("应用设置")
						.setMessage("亲~ 是否允许本应用使用您的SD卡？")
						.setPositiveButton("允许", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								writeIntoShared("useSDCard", 1);
								Toast.makeText(getApplicationContext(), "设置成功",
										Toast.LENGTH_SHORT).show();
								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									Log.e("Exception1", "whywhy1");
								}								
								task = new JsonAnalysisTask(MainActivity.this);
								task.execute(choosedCity, spell);
							}
						})
						.setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								writeIntoShared("useSDCard", 0);
								Toast.makeText(getApplicationContext(), "您可能会后悔的。。。",
										Toast.LENGTH_SHORT).show();
								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									Log.e("Exception2", "whywhy2");
								}
								task = new JsonAnalysisTask(MainActivity.this);
								task.execute(choosedCity, spell);
							}
						}).show();
						
					}
				})
				.setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
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
	
	private void theClear(){
		writeIntoShared("useNet", 0);
		writeIntoShared("useSDCard", 0);
	}
}
