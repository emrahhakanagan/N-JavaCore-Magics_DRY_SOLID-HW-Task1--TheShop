package org.example.message;

import org.example.shoping.Order;


public class MailMessage implements SendMessage {
    private Order order;
    public MailMessage(Order order)
    {
        this.order = order;
    }

    @Override
    public void sendMessage() {
        System.out.println("---MAIL MESSAGE INFO---------------------------------");
        System.out.println("Information about your order as bellow message has been sent  by email to your email address;");
        System.out.println("Your payment " + order.getTotalPrice() + "rub. has been received for order No:  "
                + order.getOrderId());
        System.out.println("Your order is on processing ...");
        System.out.println("=====================================================");
    }
}
