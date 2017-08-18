package com.lihangogo.lhweather.entity.aqi;

import java.io.Serializable;

/**
 * @author lihan
 */
public class AirQualityIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8317792029344676936L;
	private AQICity city;

	public AirQualityIndex() {
		super();
	}

	public AirQualityIndex(AQICity city) {
		super();
		this.city = city;
	}

	public AQICity getCity() {
		return city;
	}

	public void setCity(AQICity city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AirQualityIndex [city=" + city + "]";
	}
}
