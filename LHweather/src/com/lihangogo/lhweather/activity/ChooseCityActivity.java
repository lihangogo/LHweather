package com.lihangogo.lhweather.activity;

import java.io.File;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;

import com.example.lhweather.R;
import com.lihangogo.lhweather.util.CityInforDBHelper;

public class ChooseCityActivity extends Activity {
	private CityInforDBHelper helper=null;
	private final int DB_EXISTS=0;
	private final int DB_COPY_COMPLETE=1;
	private final int DB_COPY_START=2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		copyCityToDB();
	}
	
	private void copyCityToDB(){
		File dbFile=getDatabasePath(CityInforDBHelper.DB_WEATHER_NAME);
		if(dbFile.exists()){
			handler.sendEmptyMessage(DB_COPY_START);
			return;
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				copy();
			}
		});
	}
	
	private void copy(){
		
	}
	
	private Handler handler=new Handler(new Callback() {
		@Override
		public boolean handleMessage(Message arg0) {
			int what = arg0.what;
            switch (what)
            {
                case DB_EXISTS:
                {                 
                    Log.e("path","path1");
                	break;
                }
                case DB_COPY_START:
                {               
                	Log.e("path","path2");
                    break;
                }
                case  DB_COPY_COMPLETE:
                {
                	Log.e("path","path3");
                    break;
                }
            }
            return false;
		}
	});
}
