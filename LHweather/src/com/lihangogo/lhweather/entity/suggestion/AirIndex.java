package com.lihangogo.lhweather.entity.suggestion;

/**
 * 
 * @author lihan
 */
public class AirIndex {
	/*
	 * 简介
	 */
	private String brf;
	/*
	 * 数据详情
	 */
	private String txt;
	
	public String getBrf() {
		return brf;
	}
	
	public void setBrf(String brf) {
		this.brf = brf;
	}
	
	public String getTxt() {
		return txt;
	}
	
	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public AirIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	
	public AirIndex() {
		super();
	}
	
	@Override
	public String toString() {
		return "CarWash [brf=" + brf + ", txt=" + txt + "]";
	}
}
