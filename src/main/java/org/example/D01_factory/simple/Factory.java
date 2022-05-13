package org.example.D01_factory.simple;

public class Factory {
    public Milk getMilk(String name) {
        Milk milk = null;
        if ("伊利".equals(name)) {
            milk = new YiLiMilk();
        } else if ("蒙牛".equals(name)) {
            milk = new MengNiuMilk();
        } else if ("特仑苏".equals(name)) {
            milk = new TeLunSuMilk();
        } else if ("三鹿".equals(name)) {
            milk = new SanLuMilk();
        }else {
            return null;
        }
        return milk;
    }
}
