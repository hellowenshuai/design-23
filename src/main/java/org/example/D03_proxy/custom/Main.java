package org.example.D03_proxy.custom;


import org.example.D03_proxy.jdk.*;

/**
 * 代理优点：屏蔽目标类，安全。
 * 由于Son是一个具体类，拓展性较差。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=====找对象=====");
        GPJDKMeiPo jdkMeiPo = new GPJDKMeiPo();
        Person instance = (Person) jdkMeiPo.getInstance(new ChenSS());
        instance.findLove();

    }
}
