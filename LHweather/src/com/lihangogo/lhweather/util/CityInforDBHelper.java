package com.lihangogo.lhweather.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CityInforDBHelper extends SQLiteOpenHelper {
	/**
	 * 文件名
	 */
	public static final String DB_WEATHER_FILENAME = "t_city.db";
	
	/**
	 * 数据库名称
	 */
	public static final String DB_WEATHER_NAME = "LhWeather.db";
	public static final int DB_WEATHER_VERSION = 1;

	/**
	 * 表：存储中国城市信息
	 */
	public static final String DB_WEATHER_CITY_ID_TABLE_NAME = "t_city";

	/**
	 * 表：存储已订阅的城市
	 */
	public static final String DB_WEATHER_SUBSCRIBE_ID_TABLE_NAME = "t_subscribe";

	/**
	 * 两张表的列属性
	 */
	public static final String DB_WEATHER_CITY_ID = "city_id";
	
	public static final String DB_WEATHER_CITY_SPELL_ZH = "city_spell_zh";
	public static final String DB_WEATHER_CITY_CITY_AREA = "city_area";
	public static final String DB_WEATHER_CITY_CITY_TOWN = "city_town";
	public static final String DB_WEATHER_CITY_CITY_PROVINCE = "city_province";

	/**
	 * 创建city表的sql语句
	 */
	private final String CREATE_CITY_ID_TABLE = "create table "
			+ DB_WEATHER_CITY_ID_TABLE_NAME
			+ "(id integer primary key autoincrement," + DB_WEATHER_CITY_ID
			+ " text," + DB_WEATHER_CITY_SPELL_ZH + " text,"
			+ DB_WEATHER_CITY_CITY_AREA + " text," + DB_WEATHER_CITY_CITY_TOWN
			+ " text," + DB_WEATHER_CITY_CITY_PROVINCE + " text)";

	/**
	 * 创建subscribe表的sql语句
	 */
	private final String CREATE_SUBSCRIBE_ID_TABLE = "create table "
			+ DB_WEATHER_SUBSCRIBE_ID_TABLE_NAME
			+ "(id integer primary key autoincrement," + DB_WEATHER_CITY_ID
			+ " text," + DB_WEATHER_CITY_SPELL_ZH + " text,"
			+ DB_WEATHER_CITY_CITY_AREA + " text," + DB_WEATHER_CITY_CITY_TOWN
			+ " text," + DB_WEATHER_CITY_CITY_PROVINCE + " text)";

	public CityInforDBHelper(Context context) {
		super(context, DB_WEATHER_NAME, null, DB_WEATHER_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(CREATE_CITY_ID_TABLE);
		arg0.execSQL(CREATE_SUBSCRIBE_ID_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}
}
