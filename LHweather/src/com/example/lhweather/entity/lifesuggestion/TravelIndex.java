package com.example.lhweather.entity.lifesuggestion;

public class TravelIndex {
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
	public TravelIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public TravelIndex() {
		super();
	}
	@Override
	public String toString() {
		return "TravelIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
