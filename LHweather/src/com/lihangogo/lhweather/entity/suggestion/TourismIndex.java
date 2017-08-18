package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

public class TourismIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7807617351783348020L;
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
	public TourismIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public TourismIndex() {
		super();
	}
	@Override
	public String toString() {
		return "TravelIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
