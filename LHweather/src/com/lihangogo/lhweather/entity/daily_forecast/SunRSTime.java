package com.lihangogo.lhweather.entity.daily_forecast;

import com.google.gson.annotations.SerializedName;

/**
 * 天文指数
 * @author lihan
 */
public class SunRSTime {
	/*
	 * 日出时间
	 */
	@SerializedName("sr")
	private String sunRise;
	/*
	 * 日落时间
	 */
	@SerializedName("ss")
	private String sunSet;
	/*
	 * 月升时间
	 */
	@SerializedName("mr")
	private String moonRise;
	/*
	 * 月落时间
	 */
	@SerializedName("ms")
	private String moonSet;
	
	
	public String getSunRise() {
		return sunRise;
	}

	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}

	public String getSunSet() {
		return sunSet;
	}

	public void setSunSet(String sunSet) {
		this.sunSet = sunSet;
	}

	public String getMoonRise() {
		return moonRise;
	}

	public void setMoonRise(String moonRise) {
		this.moonRise = moonRise;
	}

	public String getMoonSet() {
		return moonSet;
	}

	public void setMoonSet(String moonSet) {
		this.moonSet = moonSet;
	}

	@Override
	public String toString() {
		return "SunRSTime [sunRise=" + sunRise + ", sunSet=" + sunSet
				+ ", moonRise=" + moonRise + ", moonSet=" + moonSet + "]";
	}
}
