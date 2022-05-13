package org.example.D03_proxy.cglib;


import org.example.D03_proxy.jdk.*;

/**
 * 代理优点：屏蔽目标类，安全。
 * 由于Son是一个具体类，拓展性较差。
 */
public class Main {
    public static void main(String[] args) {
        CglibMeiPo cglibMeiPo = new CglibMeiPo();
        ZhangSan zhangSan = (ZhangSan) cglibMeiPo.getInstance(ZhangSan.class);
        zhangSan.findLove();

    }
}
