package org.example.D06_observer.subject;

import org.example.D06_observer.core.Event;

public class B_ObserverImpl implements Observer {
    @Override
    public void advice(Event e) {
        System.out.println("=========B触发事件，打印日志========\n" + e);
    }
}
