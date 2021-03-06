package com.lihangogo.lhweather.entity.suggestion;

import java.io.Serializable;

/**
 * @author lihan
 */
public class Suggestion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6485878819956807543L;

	/*
	 * 空气指数
	 */
	private AirIndex air;
	
	/*
	 * 舒适度指数
	 */
	private ComfortIndex comf;
	
	/*
	 * 穿衣指数
	 */
	private DressingIndex drsg;
	
	/*
	 * 紫外线指数
	 */
	private UvIndex uv;
	
	/*
	 * 洗车指数
	 */
	private	CarWashIndex cw;
	
	/*
	 * 旅游指数
	 */
	private TourismIndex trav;
	
	/*
	 * 感冒指数
	 */
	private FluIndex flu;
	
	/*
	 * 运动指数
	 */
	private SportIndex sport;
	
	public Suggestion(ComfortIndex comf, DressingIndex drsg, UvIndex uv, CarWashIndex cw,
			TourismIndex trav, FluIndex flu, SportIndex sport) {
		super();
		this.comf = comf;
		this.drsg = drsg;
		this.uv = uv;
		this.cw = cw;
		this.trav = trav;
		this.flu = flu;
		this.sport = sport;
	}
	
	public Suggestion(AirIndex air,ComfortIndex comf, DressingIndex drsg, UvIndex uv, CarWashIndex cw,
			TourismIndex trav, FluIndex flu, SportIndex sport) {
		super();
		this.air=air;
		this.comf = comf;
		this.drsg = drsg;
		this.uv = uv;
		this.cw = cw;
		this.trav = trav;
		this.flu = flu;
		this.sport = sport;
	}
	
	public Suggestion() {
		super();
	}
	
	public ComfortIndex getComf() {
		return comf;
	}
	
	public void setComf(ComfortIndex comf) {
		this.comf = comf;
	}
	
	public DressingIndex getDrsg() {
		return drsg;
	}
	
	public void setDrsg(DressingIndex drsg) {
		this.drsg = drsg;
	}
	
	public UvIndex getUv() {
		return uv;
	}
	
	public void setUv(UvIndex uv) {
		this.uv = uv;
	}
	
	public CarWashIndex getCw() {
		return cw;
	}
	
	public void setCw(CarWashIndex cw) {
		this.cw = cw;
	}
	
	public TourismIndex getTrav() {
		return trav;
	}
	
	public void setTrav(TourismIndex trav) {
		this.trav = trav;
	}
	
	public FluIndex getFlu() {
		return flu;
	}
	
	public void setFlu(FluIndex flu) {
		this.flu = flu;
	}
	
	public SportIndex getSport() {
		return sport;
	}
	
	public void setSport(SportIndex sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "Suggestion [air=" + air + ", comf=" + comf + ", drsg=" + drsg
				+ ", uv=" + uv + ", cw=" + cw + ", trav=" + trav + ", flu="
				+ flu + ", sport=" + sport + "]";
	}
}
