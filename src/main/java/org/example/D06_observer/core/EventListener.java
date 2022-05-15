package org.example.D06_observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 86158
 */
public class EventListener {

    //Map相当于是一个注册器
    public Map<Enum, Event> events = new HashMap<Enum, Event>();

    public void addListener(Enum eventType, Object target, Method callback) {
        //注册事件
        //用反射调用这个方法
        events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event e) {
        e.setSource(this);
        e.setTime(System.currentTimeMillis());
        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }


    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        Event event = this.events.get(call).setTrigger(call.toString());
        trigger(event);
    }

}
