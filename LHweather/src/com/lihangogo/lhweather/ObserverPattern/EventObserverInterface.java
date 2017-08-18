package com.lihangogo.lhweather.ObserverPattern;

/**
 * 观察者接口
 * @author lihan
 */
public interface EventObserverInterface {
	/**
	 * 根据事件进行数据或者UI的更新
	 * @param eventType
	 */
	public void dispatchChange(String eventType);
}
