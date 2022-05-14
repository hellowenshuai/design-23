package org.example.D02_single.lanhan;

import org.example.D02_single.ehan.Singleton;

/**
 * 懒汉式
 * 说到懒，我们自然而然会想到拖延症这一恶习，这一点和懒汉式的单例实现方式相似，这一实现方式会一直等到真正需要使用对象实例的时候再去创建该实例
 * 问题：出现线程安全，if（null == singleton）会同时进入多个线程，生成多个实例
 *
 * @author 86158
 */
public class Singleton01 {
    private static Singleton01 singleton = null;

    private Singleton01() {
    }

    /**
     * V1
     * if（null == singleton）会同时进入多个线程，生成多个实例
     *
     * @return
     */
    public static Singleton01 getInstance() {
        if (null == singleton) {
            singleton = new Singleton01();
        }
        return singleton;
    }

    /**
     * V2
     * 方法签名上添加synchronized，解决线程安全问题，出现效率过慢
     *
     * @return
     */
    public static synchronized Singleton01 getInstanceV2() {
        if (null == singleton) {
            singleton = new Singleton01();
        }
        return singleton;
    }

    /**
     * V3
     * 双重检查加锁机制
     *
     * @return
     */
    public static Singleton01 getInstanceV3() {
        // 第一重检查：如果instance未被初始化，则进入同步代码块
        if (null == singleton) {
            // 同步代码块，保证线程安全
            synchronized (Singleton01.class) {
                //  第二重检查：如果instance未被初始化，则初始化该类实例
                if (null == singleton) {
                    singleton = new Singleton01();
                }
            }
        }
        return singleton;
    }


}
