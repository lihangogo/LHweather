package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

/**
 * 
 * @author lihan
 */
public class AirIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2300752397517123275L;
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
