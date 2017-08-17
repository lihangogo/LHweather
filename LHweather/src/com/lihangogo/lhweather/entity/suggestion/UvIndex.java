package com.lihangogo.lhweather.entity.suggestion;

public class UvIndex {
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
