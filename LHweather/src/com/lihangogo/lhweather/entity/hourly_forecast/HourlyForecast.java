package com.lihangogo.lhweather.entity.hourly_forecast;

import java.io.Serializable;

import com.lihangogo.lhweather.entity.daily_forecast.Wind;

/**
 * @author lihan
 */
public class HourlyForecast implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4758789983714827676L;

	/*
	 * 天气状况
	 */
	private HourlyForecastCond cond;
	
	/*
	 * 日期
	 */
	private String date;
	
	/*
	 * 相对湿度
	 */
	private int hum;
	
	/*
	 * 降水概率
	 */
	private int pop;
	
	/*
	 * 气压
	 */
	private int pres;
	
	/*
	 * 温度
	 */
	private String tmp;
	
	/*
	 * 风
	 */
	private Wind wind;
	
	public HourlyForecast(HourlyForecastCond cond,String date, int hum, int pop, int pres, Wind wind, String tmp) {
		super();
		this.cond=cond;
		this.date = date;
		this.hum = hum;
		this.pop = pop;
		this.pres = pres;
		this.wind = wind;
		this.tmp = tmp;
	}
	
	public HourlyForecast() {
		super();
	}
	
	public HourlyForecastCond getCond() {
		return cond;
	}
	
	public void setCond(HourlyForecastCond cond) {
		this.cond = cond;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getHum() {
		return hum;
	}
	
	public void setHum(int hum) {
		this.hum = hum;
	}
	
	public int getPop() {
		return pop;
	}
	
	public void setPop(int pop) {
		this.pop = pop;
	}
	
	public int getPres() {
		return pres;
	}
	
	public void setPres(int pres) {
		this.pres = pres;
	}
	
	public Wind getWind() {
		return wind;
	}
	
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	public String getTmp() {
		return tmp;
	}
	
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}

	@Override
	public String toString() {
		return "HourlyForecast [cond=" + cond + ", date=" + date + ", hum="
				+ hum + ", pop=" + pop + ", pres=" + pres + ", tmp=" + tmp
				+ ", wind=" + wind + "]";
	}
}
