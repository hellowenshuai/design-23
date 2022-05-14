package org.example.D04_strategy;

public class WeChatPayment implements Payment {
    @Override
    public PayState pay(String uuid, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("查询账号余额，开始支付");
        return new PayState(200, amount, "支付成功");
    }
}
