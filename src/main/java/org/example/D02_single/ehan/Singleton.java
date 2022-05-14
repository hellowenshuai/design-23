package org.example.D02_single.ehan;

/**
 * 饿汉式单例
 *
 * @author 86158
 */
public class Singleton {
    /**
     * 定义变量
     */
    private static Singleton singleton = new Singleton();

    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    /**
     * 定义获取实列方法
     */
    public static Singleton getInstance() {
        return singleton;
    }
}
