package org.example.D02_single.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 饿汉式单例
 *
 * @author 86158
 */
public class Singleton {
    /**
     * 定义变量
     */
    private static final String KEY = "CACHE";
    /**
     * 类实例缓存容器
     */
    private static Map<String, Singleton> map = new HashMap<>();

    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    /**
     * 定义获取实列方法
     * 上述实现方式暂未考虑线程安全问题。事实上，利用缓存来实现的单例模式其最大的优点在于对单例模式进行扩展。双例模式
     */
    public static Singleton getInstance() {
        //  尝试从缓存容器中获取类实例
        Singleton instance = map.get(KEY);
        //  未能获取类实例，则初始化该实例，并将其缓存至容器中
        if (instance == null) {
            instance = new Singleton();
            map.put(KEY, instance);
        }
        return instance;
    }

    /**
     * 可创建的最大类实例数，这里以“双例模式”为例
     */
    private static final int MAX = 2;

    /**
     * 当前正在使用的实例序号
     */
    private static int index = 1;

    /**
     * 双例模式
     *
     * @return
     */
    public static Singleton getInstanceV2() {
        //  尝试从缓存容器中获取类实例
        String key = KEY + index;

        Singleton instance = map.get(key);
        //  未能获取类实例，则初始化该实例，并将其缓存至容器中
        if (instance == null) {
            instance = new Singleton();
            map.put(key, instance);
        }
        if ((++index) > MAX) {
            // todo index =3 会被重置成1
            index = 1;
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Singleton instanceV2 = Singleton.getInstanceV2();
//            System.out.println(instanceV2);
        }
    }
}
