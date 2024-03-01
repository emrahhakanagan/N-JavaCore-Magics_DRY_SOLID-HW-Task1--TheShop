package org.example.delivery_type;

import org.example.delivery_transport.DeliveryTransport;
import org.example.message.MailMessage;
import org.example.message.SMSMessage;
import org.example.message.SendMessage;
import org.example.payment.PaySystem;
import org.example.person.Person;
import org.example.shoping.Order;

import java.util.List;

public class DeliveryInfoServiceManager {
    private String deliveryType;
    private String sendMessageType;
    private Order order;
    private List<Person> persons;
    private PaySystem paySystem;


    public DeliveryInfoServiceManager(
            String deliveryType,
            String sendMessageType,
            Order order,
            List<Person> persons,
            PaySystem paySystem
            )
    {
        this.deliveryType = deliveryType;
        this.sendMessageType = sendMessageType;

        this.order = order;
        this.persons = persons;
        this.paySystem = paySystem;
    }

    public void showStatusDelivery() {
        sendMessageAboutDeliveryInfo();
        chooseSendingMessageType(sendMessageType).sendMessage();
    }


    public SendMessage chooseSendingMessageType(String messageTypeChoosing) {
        if (messageTypeChoosing.equalsIgnoreCase("mail")) {
            return new MailMessage(order);
        } else {
            return new SMSMessage(order);
        }
    }

    public DeliveryType chooseDeliveryType(String deliveryTypeChoosing) {
        if (deliveryTypeChoosing.equalsIgnoreCase("normal")) {
            return new NormalDelivery();
        } else {
            return new ExpressDelivery();
        }
    }

    public void sendMessageAboutDeliveryInfo() {
        System.out.println("===DELIVERY STATUS================================");
        System.out.println("Dear  " + persons.get(0).getName() + " " + persons.get(0).getSurname() + " !");
        System.out.println("Your payment " + order.getTotalPrice() + "rub. has been received for order No:  "
                + order.getOrderId());
        System.out.println("Your sales manager: " + persons.get(1).getName() + " " + persons.get(1).getSurname());
        System.out.println("Your Courier: " + persons.get(2).getName() + " " + persons.get(2).getSurname());
        chooseDeliveryType(deliveryType).printInfoDeliveryType();
        System.out.println();
    }

}
