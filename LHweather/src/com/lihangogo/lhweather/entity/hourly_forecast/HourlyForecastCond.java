package com.lihangogo.lhweather.entity.hourly_forecast;

/**
 * 
 * @author lihan
 *
 */
public class HourlyForecastCond {

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
