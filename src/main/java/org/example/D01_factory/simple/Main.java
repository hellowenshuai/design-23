package org.example.D01_factory.simple;

public class Main {

    public static void main(String[] args) {
        //此时使用简单工厂，当客户端这里改变，需要直接改动代码。
        Factory factory = new Factory();
        Milk yiLi = factory.getMilk("特仑苏");
        System.out.println(yiLi.getName());

        Milk sanlu = factory.getMilk("三鹿");//这里需要修改，容易出错。不能编译检查，而且需要修改工厂类之前的方法。
        System.out.println(sanlu.getName());
    }
}
