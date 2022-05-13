package org.example.D01_factory.method;


import org.example.D01_factory.simple.Milk;

public class Main {

    public static void main(String[] args) {
        //此时使用工厂方法，利用各个具体工厂，生产对应产品，
        Factory factory = new TeLunSuFactory();
        Milk milk = factory.getMilk();
        System.out.println(milk.getName());

        // 此时新增三鹿，1，新建三鹿工厂，2.新建三鹿牛奶
        Factory sanLuFactory = new SanLuFactory();//todo 这里修改 可以编译检查，但是需要创造对象
        Milk sanLuMilk = sanLuFactory.getMilk();
        System.out.println(sanLuMilk.getName());

    }
}
