package org.example.message;

import org.example.shoping.Order;

public class SMSMessage implements SendMessage {
    private Order order;

    public SMSMessage(Order order) {
        this.order = order;
    }

    @Override
    public void sendMessage() {
        System.out.println("---SMS MESSAGE INFO----------------------------------");
        System.out.println("Information about your order as bellow message has been sent by sms to your mobile phone;");
        System.out.println("Your payment " + order.getTotalPrice() + "rub. has been received for order No:  "
                + order.getOrderId());
        System.out.println("Your order is on processing ...");
        System.out.println("=====================================================");
    }
}
