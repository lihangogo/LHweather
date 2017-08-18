package com.lihangogo.lhweather.entity.daily_forecast;

import java.io.Serializable;

/**
 * 
 * @author lihan
 */
public class DayAndNightTemperature implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 930728518676649271L;
	/*
	 * 最高温度
	 */
	private int max;
	/*
	 * 最低温度
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
