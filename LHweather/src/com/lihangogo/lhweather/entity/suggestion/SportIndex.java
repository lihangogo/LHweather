package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

public class SportIndex implements Serializable{
	/**
	 * 
	 */
	private String brf;
	/**
	 * 
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
	public SportIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public SportIndex() {
		super();
	}
	@Override
	public String toString() {
		return "SportIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
