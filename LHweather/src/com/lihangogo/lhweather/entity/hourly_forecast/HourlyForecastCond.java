package com.lihangogo.lhweather.entity.hourly_forecast;

import java.io.Serializable;

/**
 * 
 * @author lihan
 *
 */
public class HourlyForecastCond implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5232499443133447027L;

	/*
	 * 天气状况代码
	 */
	private int code;
	
	/*
	 * 数据详情
	 */
	private String txt;

	public HourlyForecastCond(int code, String txt) {
		super();
		this.code = code;
		this.txt = txt;
	}

	public HourlyForecastCond() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public String toString() {
		return "HourlyForecastCond [code=" + code + ", txt=" + txt + "]";
	}
}
