package com.example.lhweather.entity.lifesuggestion;

public class CarWashIndex {
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
	public CarWashIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public CarWashIndex() {
		super();
	}
	@Override
	public String toString() {
		return "CarWashIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
