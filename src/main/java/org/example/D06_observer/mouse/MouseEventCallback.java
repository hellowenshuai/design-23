package org.example.D06_observer.mouse;

import org.example.D06_observer.core.Event;

/**
 * @author 86158
 */
public class MouseEventCallback {
    public void click(Event e) {
        System.out.println("这是鼠标单击以后要执行的逻辑");
        System.out.println("=========触发事件，打印日志========\n" + e);
    }
}
