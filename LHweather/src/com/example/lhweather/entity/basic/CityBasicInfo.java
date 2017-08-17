package com.example.lhweather.entity.basic;

/**
 * @author lihan
 */
public class CityBasicInfo {
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String cnty;
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private double lat;
	/**
	 * 
	 */
	private double lon;
	/**
	 * 
	 */
	private WeatherUpdateTime update;
	public CityBasicInfo(String city, String cnty, String id, double lat, double lon, WeatherUpdateTime update) {
		super();
		this.city = city;
		this.cnty = cnty;
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
	public String getCnty() {
		return cnty;
	}
	public void setCnty(String cnty) {
		this.cnty = cnty;
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
		return "CityBasicInfo [city=" + city + ", cnty=" + cnty + ", id=" + id + ", lat=" + lat + ", lon=" + lon
				+ ", update=" + update + "]";
	}
	
	
}
