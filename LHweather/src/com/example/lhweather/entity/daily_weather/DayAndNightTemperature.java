package com.example.lhweather.entity.daily_weather;

public class DayAndNightTemperature {
	/**
	 * 
	 */
	private int max;
	/**
	 * 
	 */
	private int min;
	public DayAndNightTemperature(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	public DayAndNightTemperature() {
		super();
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "DayAndNightTemperature [max=" + max + ", min=" + min + "]";
	}
}
