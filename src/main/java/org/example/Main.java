package org.example;

import org.example.delivery_type.DeliveryInfoServiceManager;
import org.example.inventory.Inventory;
import org.example.payment.CreditCard;
import org.example.payment.PaySystem;
import org.example.person.*;
import org.example.shoping.CartShopping;
import org.example.shoping.Order;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person client = new Client("Dmitriy", "Tsiolkovskii", 29, Role.CLIENT);
        Person salesman = new Salesman("Evelina", "Karnitskaya", 25, Role.SALESMAN);
        Person motoCourier = new Client("Konstantin", "Hvorostovsky", 27, Role.MOTO_COURIER);
        List<Person> personsForService = Arrays.asList(client, salesman, motoCourier);

        System.out.println("--------------------------------------------");

        Inventory inventory = new Inventory();
        inventory.addProduct("Product1", 100.00, 25);
        inventory.addProduct("Product2", 250.00, 50);
        inventory.showProducts();

        System.out.println("--------------------------------------------");

        CartShopping cartShopping = new CartShopping(inventory);
        cartShopping.addProduct("Product1", 5);
        cartShopping.addProduct("Product2", 12);
        System.out.println(cartShopping.getProducts());
        System.out.println("Total price : " + cartShopping.getTotalPrice() + "rub");

        String deliveryTypeChoosing = "normal"; // Choosing of client
        String messageSendingTypeChoosing = "mail"; // Choosing of client

        System.out.println("--------------------------------------------");

        PaySystem creditCard = new CreditCard(cartShopping);
        Order order = new Order(cartShopping, creditCard, inventory);
        order.showOrderStatus();

        System.out.println("--------------------------------------------");

        System.out.println("Available Products;");
        inventory.showProducts();

        System.out.println("--------------------------------------------\n");

        DeliveryInfoServiceManager deliveryInfoServiceManager = new DeliveryInfoServiceManager(
                deliveryTypeChoosing, messageSendingTypeChoosing, order, personsForService, creditCard);
        deliveryInfoServiceManager.showStatusDelivery();
    }
}
