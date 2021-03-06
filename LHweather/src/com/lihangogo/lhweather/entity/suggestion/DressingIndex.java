package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

/**
 * 
 * @author lihan
 */
public class DressingIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2890557056610159678L;

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
	public DressingIndex(String brf, String txt) {
		super();
		this.brf = brf;
		this.txt = txt;
	}
	public DressingIndex() {
		super();
	}
	@Override
	public String toString() {
		return "DressIndex [brf=" + brf + ", txt=" + txt + "]";
	}
	
}
