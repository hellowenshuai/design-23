package org.example.D04_strategy;

/**
 * @author 86158
 */
public interface Payment {
    PayState pay(String uuid,double amount);
}
