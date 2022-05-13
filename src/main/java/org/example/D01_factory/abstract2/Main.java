package org.example.D01_factory.abstract2;


public class Main {

    public static void main(String[] args) {
        //此时使用工厂方法，利用各个具体工厂，生产对应产品，
        AbstractFactory factory = new MilkFactory();//todo 不用重新创建对象，直接调用新方法即可。也不修改原有方法。
        System.out.println(factory.getMengNiu());

        // 此时新加一个三鹿
        System.out.println(factory.getSanLu());


    }
}
