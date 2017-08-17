package com.lihangogo.lhweather.entity.alarms;

/**
 * 
 * @author lihan
 */
public class AlarmsIndex {
	/*
	 * 预警级别
	 */
	private String level;
	
	/*
	 * 预警状态
	 */
	private String stat;
	
	/*
	 * 预警标题
	 */
	private String title;
	
	/*
	 * 数据详情
	 */
	private String txt;
	
	/*
	 * 预警种类
	 */
	private String type;
		
	public AlarmsIndex(String level, String stat, String title, String txt,
			String type) {
		super();
		this.level = level;
		this.stat = stat;
		this.title = title;
		this.txt = txt;
		this.type = type;
	}
	
	public AlarmsIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getStat() {
		return stat;
	}
	
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTxt() {
		return txt;
	}
	
	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "AlarmsIndex [level=" + level + ", stat=" + stat + ", title="
				+ title + ", txt=" + txt + ", type=" + type + "]";
	}
}
