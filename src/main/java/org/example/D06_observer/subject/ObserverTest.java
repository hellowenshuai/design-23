package org.example.D06_observer.subject;


import org.example.D06_observer.core.Event;

import java.lang.reflect.Method;

public class ObserverTest {

    public static void main(String[] args) {
        //观察者
        Observer observer = new A_ObserverImpl();
        Method advice = null;
        try {
            advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //这里写Lily
        Subject subject = new Subject();
        subject.addListener(SubjectEventType.ON_ADD, observer, advice);
        subject.add();
    }
}
