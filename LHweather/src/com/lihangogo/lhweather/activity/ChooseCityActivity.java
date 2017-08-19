package com.lihangogo.lhweather.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.example.lhweather.R;
import com.lihangogo.lhweather.util.CityInforDBHelper;

public class ChooseCityActivity extends Activity {
	private CityInforDBHelper helper = null;
	private final int DB_EXISTS = 0;
	private final int DB_COPY_COMPLETE = 1;
	private final int DB_COPY_START = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		copyCityToDB();
	}

	private void copyCityToDB() {
		File dbFile = getDatabasePath(CityInforDBHelper.DB_WEATHER_NAME);
		Log.e("dbFilePath",""+dbFile);
		if (dbFile.exists()) {
			Log.e("dbfile", "aa1");
			boolean b = dbFile.delete();
			Log.e("bb", "" + b);
			handler.sendEmptyMessage(DB_EXISTS);
			return;
		} else {
			new Thread(new Runnable(){
				@Override
				public void run() {
					copy();
				}
			}).start();
		}
	}

	private void copy() {		
		handler.sendEmptyMessage(DB_COPY_START);
		BufferedReader reader = null;
		CityInforDBHelper helper = new CityInforDBHelper(
				ChooseCityActivity.this);
		SQLiteDatabase sqliteDatabase = helper.getWritableDatabase();
		String tableName = CityInforDBHelper.DB_WEATHER_CITY_ID_TABLE_NAME;
		ContentValues values = new ContentValues();

		try {
			String DB_WEATHER_CITY_ID = CityInforDBHelper.DB_WEATHER_CITY_ID;
			String DB_WEATHER_CITY_SPELL_ZH = CityInforDBHelper.DB_WEATHER_CITY_SPELL_ZH;
			String DB_WEATHER_CITY_CITY_AREA = CityInforDBHelper.DB_WEATHER_CITY_CITY_AREA;
			String DB_WEATHER_CITY_CITY_TOWN = CityInforDBHelper.DB_WEATHER_CITY_CITY_TOWN;
			String DB_WEATHER_CITY_CITY_PROVINCE = CityInforDBHelper.DB_WEATHER_CITY_CITY_PROVINCE;

			reader = new BufferedReader(new InputStreamReader(getAssets().open(
					CityInforDBHelper.DB_WEATHER_FILENAME), "UTF-8"));
			while (true) {
				String strLine = reader.readLine();
				if (TextUtils.isEmpty(strLine)) {
					break;
				}			
				String[] cityInfos = strLine.trim().split("\t");				
				if (cityInfos != null && cityInfos.length > 0) {
					String id = cityInfos[2];
					String spell_zh = cityInfos[3];
					String area = cityInfos[4];
					String town = cityInfos[5];
					String province = cityInfos[6];
					values.put(DB_WEATHER_CITY_ID, id);
					values.put(DB_WEATHER_CITY_SPELL_ZH, spell_zh);
					values.put(DB_WEATHER_CITY_CITY_AREA, area);
					values.put(DB_WEATHER_CITY_CITY_TOWN, town);
					values.put(DB_WEATHER_CITY_CITY_PROVINCE, province);
					Log.e("num",""+values.toString());
					sqliteDatabase.insert(tableName, null, values);
				}
			}
		} catch (Exception e) {
			Log.e("Exception1", "" + e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					Log.e("Exception2", "" + e);
				}
			}
			if (sqliteDatabase != null) {
				try {
					sqliteDatabase.close();
				} catch (Exception e) {
					Log.e("Exception3", "" + e);
				}
			}
		}
		handler.sendEmptyMessage(DB_COPY_COMPLETE);
		SQLiteDatabase dd=helper.getReadableDatabase();
		Cursor c=dd.rawQuery("select * from t_city",null);
		while(c.moveToNext()){
			String ss=c.getString(c.getColumnIndex("city_area"));
			Log.e("ss",ss);
		}
	}

	private Handler handler = new Handler(new Callback() {
		@Override
		public boolean handleMessage(Message arg0) {
			int what = arg0.what;
			switch (what) {
			case DB_EXISTS: {
				Log.e("path", "path1");
				break;
			}
			case DB_COPY_START: {
				Log.e("path", "path2");
				break;
			}
			case DB_COPY_COMPLETE: {
				Log.e("path", "path3");
				break;
			}
			default: {
				Log.e("path", "path4");
				break;
			}
			}
			return true;
		}
	});
}
