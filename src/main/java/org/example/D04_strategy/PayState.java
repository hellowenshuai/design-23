package org.example.D04_strategy;

public class PayState {

    private int code;
    private Object data;
    private String msg;

    @Override
    public String toString() {
        return msg + "[" + code + "],支付成功，交易详情:" + data;
    }

    public PayState() {
    }

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
