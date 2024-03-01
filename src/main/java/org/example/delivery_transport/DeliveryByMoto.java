package org.example.delivery_transport;

// *** Данный класс подходит к SOLID принципу №1 Single Responsibility Principle так,
//     как доставка выполняется только МотоКурьером.
public class DeliveryByMoto implements DeliveryTransport {


    @Override
    public void deliver() {
        System.out.println("Order will be delivering by the MotoCourier within "
                + TimeDelivery.MOTO_COURIER_DELIVERY_TIME.getMin() + " min ...");
    }


    // *** Здесь применен SOLID принцип №4 -- Liskov Substitution.
    // *** Данный класс насколько имплементируют от класса DeliveryTransport, но при этом имеет свой собственный метод.
    public void refuel() {
        System.out.println("Fuel tank has been fulled ...");
    }

}
