package com.lihangogo.lhweather.ObserverPattern;

public class Notify {
	private static volatile Notify mNotify;

	private Notify() {

	}

	public static Notify getInstance() {
		if (mNotify == null) {
			mNotify = new Notify();
		}
		return mNotify;
	}

	public void NotifyActivity(String eventType) {
		EventSubject eventSubject = EventSubject.getInstance();
		EventType eventTypes = EventType.getInstance();
		if (eventTypes.contains(eventType)) {
			eventSubject.notifyObserver(eventType);
		}
	}
}
