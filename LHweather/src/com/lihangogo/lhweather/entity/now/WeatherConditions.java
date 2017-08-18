package com.lihangogo.lhweather.entity.now;

import java.io.Serializable;

/**
 * 
 * @author lihan
 */
public class WeatherConditions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 199149429178230724L;
	/*
	 * 天气代码
	 */
	private int code;
	/*
	 * 天气状况
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
