package com.lihangogo.lhweather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.lhweather.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lihangogo.lhweather.entity.QueryResultForWeatherFirst;
import com.lihangogo.lhweather.util.JsonUtil;

public class MainActivity extends Activity {
	
	public myHandler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		handler=new myHandler();
		MyThread thread=new MyThread();
		new Thread(thread).start();
	}
	
	class myHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String str=(String)msg.obj;
			Gson gson=new GsonBuilder().create();
			QueryResultForWeatherFirst aa=gson.fromJson(str,QueryResultForWeatherFirst.class);
			//gson.from
			Log.e("aa",""+aa);
		}
	}
	class MyThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			String str=JsonUtil.getJson();
			Message mss=new Message();
			mss.obj=str;
			MainActivity.this.handler.sendMessage(mss);
		}
	}

}