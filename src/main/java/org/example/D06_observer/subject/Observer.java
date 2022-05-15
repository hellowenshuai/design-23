package org.example.D06_observer.subject;

import org.example.D06_observer.core.Event;

public interface Observer {

    void advice(Event e);
//    {
//        System.out.println("=========触发事件，打印日志========\n" + e);
//
//        /*
//         *  input
//         *  input.addLisenter("click",function(){
//         *
//         *
//         *  });
//         *
//         *
//         * */
//    }
}
