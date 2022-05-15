package org.example.D06_observer.subject;

import org.example.D06_observer.core.Event;

public class A_ObserverImpl implements Observer {
    @Override
    public void advice(Event e) {
        System.out.println("=========A触发事件，打印日志========\n" + e);
    }
}
