package org.example.delivery_type;

import org.example.delivery_transport.DeliveryByMoto;
import org.example.delivery_transport.DeliveryTransport;

public class ExpressDelivery extends DeliveryType {

    DeliveryTransport deliveryTransport;

    public ExpressDelivery() {
        this.deliveryTransport = new DeliveryByMoto();
    }


    @Override
    public void printInfoDeliveryType() {
        System.out.println("Order Transfer will be by the Normal Delivery");
        deliveryTransport.deliver();
    }

}
