package com.lihangogo.lhweather.entity;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author lihan
 */
public class QueryResultForWeatherFirst implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3291591146292478623L;
	/*
	 * 最终天气集合
	 */
	@SerializedName("HeWeather5")
	private List<QueryWeatherResult> theWeather;

	public QueryResultForWeatherFirst(List<QueryWeatherResult> theWeather) {
		super();
		this.theWeather = theWeather;
	}

	public QueryResultForWeatherFirst() {
		super();
	}

	public List<QueryWeatherResult> getTheWeather() {
		return theWeather;
	}

	public void setTheWeather(List<QueryWeatherResult> theWeather) {
		this.theWeather = theWeather;
	}

	@Override
	public String toString() {
		return "QueryResultForWeatherFirst [theWeather=" + theWeather + "]";
	}
}
