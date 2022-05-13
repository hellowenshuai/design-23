package org.example.D03_proxy.statistic;

public class SonProxy {

    private Person person;

    public SonProxy(Person person) {
        this.person = person;
    }
    public void findLove(){
        System.out.println("开始寻找对象");
        this.person.findLove();
        System.out.println("结束寻找对象");
    }
}
