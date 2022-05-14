package org.example.D02_single.HolderClass;

/**
 * 静态内部类实现
 * 在前面提到的饿汉式实现方式中，我们利用Java的静态初始化、借由JVM实现了线程安全，因此这里同样采用了这种方式。而另一方面，
 * 为了避免饿汉式实现中无法进行延迟加载的缺陷，我们构造了一个类级内部类来缓存类实例，由于该类只会在通过getInstance()方法去调用时才会被系统装载，
 * 换言之，只有初次调用getInstance()方法时才会去初始化类实例，因此也实现了延迟加载这一功能。如此便可使得这一实现方式能够同时具备线程安全、
 * 延迟加载以及节省大量同步判断资源等优势，可以说是单例模式的最佳实现了
 *
 * @author 86158
 */
public class Singleton {
    /**
     * 类级内部类，用于缓存类实例
     * 该类将在被调用时才会被装载，从而实现了延迟加载
     * 同时由于instance采用静态初始化的方式，因此JVM能保证其线程安全性
     */
    private static class Instance {
        private static Singleton instance = new Singleton();
    }

    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    /**
     * 定义获取实列方法
     * 添加static关键词使得外部可以通过类名直接调用该方法获取类实例
     */
    public static Singleton getInstance() {
        return Instance.instance;
    }
}
