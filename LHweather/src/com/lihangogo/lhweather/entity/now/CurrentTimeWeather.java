package com.lihangogo.lhweather.entity.now;

import java.io.Serializable;

import com.lihangogo.lhweather.entity.daily_forecast.Wind;

/**
 * @author lihan
 */
public class CurrentTimeWeather implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -824861825088234319L;

	/*
	 * 天气状况
	 */
	private WeatherConditions cond;
	
	/*
	 * 体感温度
	 */
	private int fl;
	
	/*
	 * 相对湿度
	 */
	private int hum;
	
	/*
	 * 降水量
	 */
	private double pcpn;
	
	/*
	 * 气压
	 */
	private int pres;
	
	/*
	 * 温度
	 */
	private int tmp;
	
	/*
	 * 能见度
	 */
	private int vis;
	
	/*
	 * 风
	 */
	private Wind wind;
	
	public CurrentTimeWeather(WeatherConditions cond, int fl, int hum,
			double pcpn, int pres, int tmp, int vis, Wind wind) {
		super();
		this.cond = cond;
		this.fl = fl;
		this.hum = hum;
		this.pcpn = pcpn;
		this.pres = pres;
		this.tmp = tmp;
		this.vis = vis;
		this.wind = wind;
	}
	
	public CurrentTimeWeather() {
		super();
	}
	
	public WeatherConditions getCond() {
		return cond;
	}
	
	public void setCond(WeatherConditions cond) {
		this.cond = cond;
	}
	
	public Wind getWind() {
		return wind;
	}
	
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	public int getFl() {
		return fl;
	}
	
	public void setFl(int fl) {
		this.fl = fl;
	}
	
	public double getPcpn() {
		return pcpn;
	}
	
	public void setPcpn(double pcpn) {
		this.pcpn = pcpn;
	}
	
	public int getHum() {
		return hum;
	}
	
	public void setHum(int hum) {
		this.hum = hum;
	}
	
	public int getPres() {
		return pres;
	}
	
	public void setPres(int pres) {
		this.pres = pres;
	}
	
	public int getVis() {
		return vis;
	}
	
	public void setVis(int vis) {
		this.vis = vis;
	}
	
	public int getTmp() {
		return tmp;
	}

	public void setTmp(int tmp) {
		this.tmp = tmp;
	}

	@Override
	public String toString() {
		return "CurrentTimeWeather [cond=" + cond + ", fl=" + fl + ", hum="
				+ hum + ", pcpn=" + pcpn + ", pres=" + pres + ", tmp=" + tmp
				+ ", vis=" + vis + ", wind=" + wind + "]";
	}
}
