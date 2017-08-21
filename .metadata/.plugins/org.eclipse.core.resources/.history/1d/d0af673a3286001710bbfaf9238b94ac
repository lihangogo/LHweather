package com.lihangogo.lhweather.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.lhweather.R;
import com.lihangogo.lhweather.util.CityInforDBHelper;
import com.lihangogo.lhweather.util.DAO;
import com.lihangogo.lhweather.util.citypicker1.widget.CityPicker;

public class ChooseCityActivity extends Activity {
	private CityInforDBHelper helper = null;
	private final int DB_EXISTS = 0;
	private final int DB_COPY_COMPLETE = 1;
	private final int DB_COPY_START = 2;

	private String[] strs = null;
	private Map<String, String[]> city = null;
	private Map<String, String[]> area = null;

	private Button button = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				operation();
			}
		});
		copyCityToDB();
	}

	/**
	 * 选择是否将db文件读进数据库
	 */
	private void copyCityToDB() {
		File dbFile = getDatabasePath(CityInforDBHelper.DB_WEATHER_NAME);
		Log.e("dbFilePath", "" + dbFile);
		if (dbFile.exists()) {
			Log.e("dbfile", "aa1");
			
			handler.sendEmptyMessage(DB_EXISTS);
			return;
		} else {
			new Thread(new Runnable() {
				@Override
				public void run() {
					copy();
				}
			}).start();
		}
	}

	/**
	 * 将db文件读进数据库
	 */
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
		/*
		 * SQLiteDatabase dd=helper.getReadableDatabase(); Cursor
		 * c=dd.rawQuery("select * from t_city",null); while(c.moveToNext()){
		 * String ss=c.getString(c.getColumnIndex("city_area")); Log.e("ss",ss);
		 * }
		 */
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

	private void operation() {
		CityPicker cityPicker = new CityPicker.Builder(ChooseCityActivity.this)
				.textSize(20).titleTextColor("#000000")
				.backgroundPop(0xa0000000).province("山东").city("菏泽")
				.district("郓城").textColor(Color.parseColor("#000000"))
				.provinceCyclic(true).cityCyclic(false).districtCyclic(false)
				.visibleItemsCount(7).itemPadding(10).setProvinceData(strs)
				.setCityData(city).setAreaData(area).build();

		cityPicker.show();
		cityPicker
				.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
					@Override
					public void onSelected(Object... args) {
						String str = "选择结果：\n省(自治区)：" + args[0] + "\n市："
								+ args[1] + "\n县(旗、区)：" + args[2];

						strs = (String[]) args[3];
						city = (HashMap<String, String[]>) args[4];
						area = (HashMap<String, String[]>) args[5];
						 operation1((String)args[0],(String)args[1],(String)args[2]);
					}

					@Override
					public void onCancel(Object... args) {
						strs = (String[]) args[0];
						city = (HashMap<String, String[]>) args[1];
						area = (HashMap<String, String[]>) args[2];

						Toast.makeText(ChooseCityActivity.this, "已取消",
								Toast.LENGTH_LONG).show();
					}
				});
	}

	private void operation1(String p, String c, String a) {
		String cityId = DAO.getCityIdByName(p, c, a, ChooseCityActivity.this);
		
	}
}
