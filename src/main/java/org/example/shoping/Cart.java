package org.example.shoping;

import org.example.inventory.Product;

import java.util.Map;

public interface Cart {
    String addProduct(String productName, int quantity);

    public default boolean isProductAvailable(String productName, int quantity) {
        return false;
    }

    Map<Product, Integer> getProducts();

    double getTotalPrice();
}
