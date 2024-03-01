package org.example.shoping;

import org.example.inventory.Inventory;
import org.example.inventory.Product;
import org.example.payment.PaySystem;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Product, Integer> products = new HashMap<>();
    private String orderId;
    private double totalPrice;
    private PaySystem creditCard;
    private Inventory inventory;
    private Cart cartShopping;

    public Order(Cart cartShopping, PaySystem creditCard, Inventory inventory) {
        this.orderId = generateOrderId();
        this.products = cartShopping.getProducts();
        this.totalPrice = cartShopping.getTotalPrice();
        this.creditCard = creditCard;
        this.inventory = inventory;
        this.cartShopping = cartShopping;
    }

    public void showOrderStatus() {
        System.out.println("===ORDER STATUS================================");
        System.out.println(orderId + " has been accepted for next products;");
        System.out.println(products);
        creditCard.pay();
        inventory.reduceProduct(cartShopping);
        System.out.println("===============================================");
    }

    private String generateOrderId() {
        // Генерация уникального ID заказа
        return "ORDER" + System.currentTimeMillis();
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
