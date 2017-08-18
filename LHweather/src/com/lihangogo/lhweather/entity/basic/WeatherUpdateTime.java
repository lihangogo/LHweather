package com.lihangogo.lhweather.entity.basic;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;


public class WeatherUpdateTime implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8816455953216362442L;
	/**
	 * 当地时间
	 */
	@SerializedName("loc")
	private String localTime;
	/**
	 * UTC时间
	 */
	private String utc;
	
	public WeatherUpdateTime() {
		super();
	}
	public WeatherUpdateTime(String localTime, String utc) {
		super();
		this.localTime = localTime;
		this.utc = utc;
	}
	public String getLocalTime() {
		return localTime;
	}
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
	public String getUtc() {
		return utc;
	}
	public void setUtc(String utc) {
		this.utc = utc;
	}
	@Override
	public String toString() {
		return "WeatherUpdateTime [localTime=" + localTime + ", utc=" + utc + "]";
	}
}
