package com.lihangogo.lhweather.entity.aqi;

/**
 * @author lihan
 */
public class AirQualityIndex {
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
