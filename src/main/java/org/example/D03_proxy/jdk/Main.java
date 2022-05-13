package org.example.D03_proxy.jdk;


/**
 * 代理优点：屏蔽目标类，安全。
 * 由于Son是一个具体类，拓展性较差。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=====找对象=====");
        JDKService jdkMeiPo = new JDKMeiPo();
        Person instance = (Person) jdkMeiPo.getInstance(new ChenSS());
        instance.findLove();

        System.out.println("=====找工作=====");
        JDKService jdk58 = new JDK58();
        Person instance1 = (Person) jdk58.getInstance(new ChenSS());
        instance1.findJob();
    }
}
