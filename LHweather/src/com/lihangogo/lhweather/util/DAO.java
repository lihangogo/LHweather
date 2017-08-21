package com.lihangogo.lhweather.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lihangogo.lhweather.util.citypicker1.model.ProvinceModel;

public class DAO {
	private DAO() {

	}

	/**
	 * 获取所有城市列表
	 * 
	 * @return
	 */
	public static List<ProvinceModel> getAllCity(Context context) {
		List<ProvinceModel> list = new ArrayList<ProvinceModel>();
		SQLiteDatabase database = new CityInforDBHelper(context)
				.getReadableDatabase();
		Cursor cursor = database.rawQuery("select * from t_city", null);
		// database.qu
		String province = null, city = null, district = null;
		while (cursor.moveToNext()) {
			province = cursor.getString(cursor.getColumnIndex("city_province"));
			city = cursor.getString(cursor.getColumnIndex("city_town"));
			district = cursor.getString(cursor.getColumnIndex("city_area"));
			// if(list.contains(arg0))
		}
		cursor.close();
		database.close();
		return null;
	}

	/**
	 * 获取所有的省份
	 * 
	 * @param context
	 * @return
	 */
	public static String[] getAllProvince(Context context) {
		List<String> list = new ArrayList<String>();
		SQLiteDatabase database = new CityInforDBHelper(context)
				.getReadableDatabase();
		Cursor cursor = database.rawQuery("select city_province from t_city",
				null);
		while (cursor.moveToNext()) {
			String province = cursor.getString(cursor
					.getColumnIndex("city_province"));
			if (!list.contains(province))
				list.add(province);
		}
		cursor.close();
		database.close();
		String[] provinces = new String[list.size()];
		int i = 0;
		for (String s : list) {
			provinces[i++] = s;
		}
		return provinces;
	}

	/**
	 * 获取省份-市的格式化数据
	 * 
	 * @param context
	 * @return
	 */
	public static Map<String, String[]> getProvince2City(Context context,
			String[] province) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		Cursor cursor = null;
		SQLiteDatabase database = new CityInforDBHelper(context)
				.getReadableDatabase();
		for (int i = 0; i < province.length; i++) {
			List<String> list = new ArrayList<String>();
			cursor = database.rawQuery(
					"select city_town from t_city where city_province=?",
					new String[] { province[i] });

			while (cursor.moveToNext()) {
				String city = cursor.getString(cursor
						.getColumnIndex("city_town"));
				if (!list.contains(city))
					list.add(city);
			}
			String[] cities = new String[list.size()];
			int j = 0;
			for (String s : list) {
				cities[j++] = s;
			}
			map.put(province[i], cities);
		}
		cursor.close();
		database.close();
		return map;
	}

	/**
	 * 获取市-地区的格式化数据
	 * 
	 * @param context
	 * @return
	 */
	public static Map<String, String[]> getCity2Area(Context context) {
		List<String> list = new ArrayList<String>();
		SQLiteDatabase database = new CityInforDBHelper(context)
				.getReadableDatabase();
		Cursor cursor = database.rawQuery("select city_town from t_city", null);
		while (cursor.moveToNext()) {
			String town = cursor.getString(cursor.getColumnIndex("city_town"));
			if (!list.contains(town))
				list.add(town);
		}
		cursor.close();

		Cursor cursor2 = null;
		Map<String, String[]> map = new HashMap<String, String[]>();
		for (String tt : list) {
			List<String> list2 = new ArrayList<String>();
			cursor2 = database.rawQuery(
					"select city_area from t_city where city_town=?",
					new String[] { tt });
			while (cursor2.moveToNext()) {
				String area = cursor2.getString(cursor2
						.getColumnIndex("city_area"));
				if (!list2.contains(area))
					list2.add(area);
			}
			String[] areas = new String[list2.size()];
			int j = 0;
			for (String s : list2) {
				areas[j++] = s;
			}
			map.put(tt, areas);
		}
		cursor2.close();
		database.close();
		return map;
	}

	/**
	 * 根据省市县获取唯一的城市代码
	 * 
	 * @param province
	 *            省
	 * @param city
	 *            市
	 * @param area
	 *            县
	 * @return 城市代码
	 */
	public static String getCityIdByName(String province, String city,
			String area, Context context) {
		SQLiteDatabase database = new CityInforDBHelper(context)
				.getReadableDatabase();
		Cursor cursor = database.rawQuery(
				"select city_id from t_city where city_province=? and city_town=? "
						+ "and city_area=?", new String[] { province, city,
						area });
		String id = null;
		while (cursor.moveToNext()) {
			id = cursor.getString(cursor.getColumnIndex("city_id"));
		}
		cursor.close();
		database.close();
		return id;
	}
	
	public static boolean insertSubscribeCity(){
		
		return true;
	}
}
