package com.lihangogo.lhweather.entity.daily_forecast;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * 天气状况
 * @author lihan
 */
public class DayAndNightWeather implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7667971592812435213L;
	/*
	 * 白天天气状况代码
	 */
	@SerializedName("code_d")
	private int codeDay;
	/*
	 * 夜间天气状况代码
	 */
	@SerializedName("code_n")
	private int codeNight;
	/*
	 * 白天天气状况描述
	 */
	@SerializedName("txt_d")
	private String txtDay;
	/*
	 * 夜间天气状况描述
	 */
	@SerializedName("txt_n")
	private String txtNight;
	
	public int getCodeDay() {
		return codeDay;
	}

	public void setCodeDay(int codeDay) {
		this.codeDay = codeDay;
	}

	public int getCodeNight() {
		return codeNight;
	}

	public void setCodeNight(int codeNight) {
		this.codeNight = codeNight;
	}

	public String getTxtDay() {
		return txtDay;
	}

	public void setTxtDay(String txtDay) {
		this.txtDay = txtDay;
	}

	public String getTxtNight() {
		return txtNight;
	}

	public void setTxtNight(String txtNight) {
		this.txtNight = txtNight;
	}

	@Override
	public String toString() {
		return "DayAndNightWeather [code_day=" + codeDay + ", code_night=" + codeNight + ", txt_day=" + txtDay + ", txt_night=" + txtNight
				+ "]";
	}
}
