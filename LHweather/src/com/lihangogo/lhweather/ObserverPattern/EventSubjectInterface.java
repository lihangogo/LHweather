package com.lihangogo.lhweather.ObserverPattern;

/**
 * 主题接口
 * @author lihan
 */
public interface EventSubjectInterface {
	/**
	 * 注册观察者
	 * @param observer
	 */
	public void registerObserver(EventObserverInterface observer);
	
	/**
	 * 移除观察者
	 * @param observer
	 */
	public void removeObserver(EventObserverInterface observer);
	
	/**
	 * 通知已注册的观察者进行数据或者UI的更新
	 * @param eventType
	 */
	public void notifyObserver(String eventType);
}
