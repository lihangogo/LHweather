package com.example.lhweather.entity.lifesuggestion;

/**
 * @author lihan
 */
public class LifeSuggestion {
	/**
	 * 
	 */
	private ComfortableIndex comf;
	/**
	 * 
	 */
	private DressIndex drsg;
	/**
	 * 
	 */
	private UltravioletRayIndex uv;
	/**
	 * 
	 */
	private	CarWashIndex cw;
	/**
	 * 
	 */
	private TravelIndex trav;
	/**
	 * 
	 */
	private FluIndex flu;
	/**
	 * 
	 */
	private SportIndex sport;
	public LifeSuggestion(ComfortableIndex comf, DressIndex drsg, UltravioletRayIndex uv, CarWashIndex cw,
			TravelIndex trav, FluIndex flu, SportIndex sport) {
		super();
		this.comf = comf;
		this.drsg = drsg;
		this.uv = uv;
		this.cw = cw;
		this.trav = trav;
		this.flu = flu;
		this.sport = sport;
	}
	public LifeSuggestion() {
		super();
	}
	@Override
	public String toString() {
		return "LifeSuggestion [comf=" + comf + ", drsg=" + drsg + ", uv=" + uv + ", cw=" + cw + ", trav=" + trav
				+ ", flu=" + flu + ", sport=" + sport + "]";
	}
	public ComfortableIndex getComf() {
		return comf;
	}
	public void setComf(ComfortableIndex comf) {
		this.comf = comf;
	}
	public DressIndex getDrsg() {
		return drsg;
	}
	public void setDrsg(DressIndex drsg) {
		this.drsg = drsg;
	}
	public UltravioletRayIndex getUv() {
		return uv;
	}
	public void setUv(UltravioletRayIndex uv) {
		this.uv = uv;
	}
	public CarWashIndex getCw() {
		return cw;
	}
	public void setCw(CarWashIndex cw) {
		this.cw = cw;
	}
	public TravelIndex getTrav() {
		return trav;
	}
	public void setTrav(TravelIndex trav) {
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
	
}
