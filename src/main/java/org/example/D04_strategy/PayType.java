package org.example.D04_strategy;

/**
 * @author 86158
 */

public enum PayType {
    ALI(new ALiPayment()),
    JD(new JDPayment()),
    WeChat(new WeChatPayment());

    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return this.payment;
    }
}
