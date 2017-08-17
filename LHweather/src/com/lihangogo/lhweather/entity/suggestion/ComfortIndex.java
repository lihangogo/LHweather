package com.lihangogo.lhweather.entity.suggestion;

/**
 * 
 * @author lihan
 *
 */
public class ComfortIndex {
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
	public ComfortIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public ComfortIndex() {
		super();
	}
	@Override
	public String toString() {
		return "Comfortable [brf=" + brf + ", txt=" + txt + "]";
	}
	
}