package org.example.D04_strategy;

/**
 * @author 86158
 */
public class Order {
    private String uuid;
    private String orderNo;
    private double amount;

    public Order() {
    }

    public Order(String uuid, String orderNo, double amount) {
        this.uuid = uuid;
        this.orderNo = orderNo;
        this.amount = amount;
    }

    PayState pay(Payment payment) {
        PayState pay = payment.pay(uuid, amount);
        return pay;
    }
}
