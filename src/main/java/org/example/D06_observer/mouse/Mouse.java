package org.example.D06_observer.mouse;


import org.example.D06_observer.core.EventLisenter;

/**
 * 被观察者
 * @author 86158
 */
public class Mouse extends EventLisenter {

    public void ON_CLICK() {
        System.out.println("单击事件");
        trigger(MouseEventType.ON_CLICK);
    }

    public void ON_DOUBLE_CLICK() {
        System.out.println("双击事件");
        trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void ON_UP() {
        System.out.println("上滑事件");
        trigger(MouseEventType.ON_UP);
    }
}
