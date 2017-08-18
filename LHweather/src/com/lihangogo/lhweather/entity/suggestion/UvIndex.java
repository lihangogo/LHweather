package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

public class UvIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5255015021328625729L;
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
	public UvIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public UvIndex() {
		super();
	}
	@Override
	public String toString() {
		return "UltravioletRayIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
