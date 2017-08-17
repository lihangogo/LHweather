package com.example.lhweather.entity.now;

public class WeatherConditions {
	/**
	 * 
	 */
	private int code;
	/**
	 * 
	 */
	private String txt;
	public WeatherConditions(int code, String txt) {
		super();
		this.code = code;
		this.txt = txt;
	}
	public WeatherConditions() {
		super();
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
		return "WeatherConditions [code=" + code + ", txt=" + txt + "]";
	}
	
}
