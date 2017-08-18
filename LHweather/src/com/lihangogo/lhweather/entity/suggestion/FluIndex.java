package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

public class FluIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6882815510310034615L;
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
	public FluIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public FluIndex() {
		super();
	}
	@Override
	public String toString() {
		return "FluIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
