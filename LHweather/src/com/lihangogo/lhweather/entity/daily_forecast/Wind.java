package com.lihangogo.lhweather.entity.daily_forecast;

import com.google.gson.annotations.SerializedName;

/**
 * 风力情况
 * @author lihan
 */
public class Wind {
	
	/*
	 * 风向（360度）
	 */
	@SerializedName("deg")
	private int windDireAngle;
	
	/*
	 * 风向
	 */
	@SerializedName("dir")
	private String windDirection;
	
	/*
	 * 风力等级
	 */
	@SerializedName("sc")
	private String windScale;
	
	/*
	 * 风速
	 */
	@SerializedName("spd")
	private int windSpeed;

	public Wind(int windDireAngle, String windDirection, String windScale,
			int windSpeed) {
		super();
		this.windDireAngle = windDireAngle;
		this.windDirection = windDirection;
		this.windScale = windScale;
		this.windSpeed = windSpeed;
	}

	public Wind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getWindDireAngle() {
		return windDireAngle;
	}

	public void setWindDireAngle(int windDireAngle) {
		this.windDireAngle = windDireAngle;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindScale() {
		return windScale;
	}

	public void setWindScale(String windScale) {
		this.windScale = windScale;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public String toString() {
		return "Wind [windDireAngle=" + windDireAngle + ", windDirection="
				+ windDirection + ", windScale=" + windScale + ", windSpeed="
				+ windSpeed + "]";
	}
}