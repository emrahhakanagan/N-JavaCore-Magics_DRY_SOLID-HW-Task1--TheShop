package org.example.delivery_type;

import org.example.delivery_transport.DeliveryByBicycle;
import org.example.delivery_transport.DeliveryTransport;

public class NormalDelivery extends DeliveryType {
    DeliveryTransport deliveryTransport;


    public NormalDelivery() {
        this.deliveryTransport = new DeliveryByBicycle();
    }

    @Override
    public void printInfoDeliveryType() {
        System.out.println("Order Transfer is Normal Delivery");
        deliveryTransport.deliver();
    }

}
