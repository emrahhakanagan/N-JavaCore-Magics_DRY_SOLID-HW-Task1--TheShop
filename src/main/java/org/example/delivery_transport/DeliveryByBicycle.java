package org.example.delivery_transport;

// *** Данный класс подходит к SOLID принципу №1 Single Responsibility Principle так,
//     как доставка выполняется только ВелоКурьером.
public class DeliveryByBicycle implements DeliveryTransport {
//    private static final int BIKE_DELIVERY_TIME = 60;

    @Override
    public void deliver() {
        System.out.println("Order will be delivering by the BikeCourier within "
                + TimeDelivery.BIKE_COURIER_DELIVERY_TIME.getMin() + " min ...");
    }

}
