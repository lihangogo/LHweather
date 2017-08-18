package com.lihangogo.lhweather.entity.basic;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * @author lihan
 */
public class CityBasicInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -732397794684008511L;
	/*
	 * 城市名
	 */
	private String city;
	/*
	 * 国家
	 */
	@SerializedName("cnty")
	private String county;
	/*
	 * 城市ID
	 */
	private String id;
	/*
	 * 纬度
	 */
	private double lat;
	/*
	 * 经度
	 */
	private double lon;
	/*
	 * 天气更新时间
	 */
	private WeatherUpdateTime update;
	
	public CityBasicInfo(String city, String county, String id, double lat, double lon, WeatherUpdateTime update) {
		super();
		this.city = city;
		this.county = county;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.update = update;
	}
	public CityBasicInfo() {
		super();
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public WeatherUpdateTime getUpdate() {
		return update;
	}
	public void setUpdate(WeatherUpdateTime update) {
		this.update = update;
	}
	@Override
	public String toString() {
		return "CityBasicInfo [city=" + city + ", county=" + county + ", id=" + id + ", lat=" + lat + ", lon=" + lon
				+ ", update=" + update + "]";
	}
	
	
}
