package com.lihangogo.lhweather.ObserverPattern;

import java.util.HashSet;
import java.util.Set;

/**
 * 定义事件类型
 * @author lihan
 */
public class EventType {
	private static volatile EventType mEventType;
    private final static Set<String> eventsTypes = new HashSet<String>();

    public final static String UPDATE_MAIN="updateMain";
    private EventType(){
        eventsTypes.add(UPDATE_MAIN);
    }

    public static EventType getInstance(){
       if(mEventType==null){
           mEventType=new EventType();
       }
        return mEventType;
    }

    public boolean contains(String eventType){
        return eventsTypes.contains(eventType);
    }
}
