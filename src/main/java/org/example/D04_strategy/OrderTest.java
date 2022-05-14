package org.example.D04_strategy;

/**
 * @author 86158
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order("1111", "111", 100);
        PayState pay = order.pay(new WeChatPayment());
        System.out.println(pay);
        System.out.println("第二个版本");
        Order order2 = new Order("1111", "111", 100);
        //这里使用枚举，把选择权力交给客户端。
        PayState pay2 = order2.pay(PayType.ALI.get());
        System.out.println(pay);
    }
}
