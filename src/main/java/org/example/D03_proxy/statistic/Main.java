package org.example.D03_proxy.statistic;

/**
 * 代理优点：屏蔽目标类，安全。
 * 由于Son是一个具体类，拓展性较差。
 */
public class Main {
    public static void main(String[] args) {
        SonProxy sonProxy = new SonProxy(new Son());
        sonProxy.findLove();

        SonProxy sonProxy2 = new SonProxy(new Son2());
        sonProxy2.findLove();

    }
}
