package org.example.D06_observer.mouse;

import org.example.D06_observer.core.Event;

import java.lang.reflect.Method;

/**
 * @author 86158
 */
public class MouseTest {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();
        Method click = null;
        try {
            click = MouseEventCallback.class.getMethod("click",  new Class<?>[]{Event.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK, callback, click);
        mouse.ON_CLICK();
    }
}
