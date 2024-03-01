package org.example.shoping;

import org.example.inventory.Inventory;
import org.example.inventory.Product;

import java.util.HashMap;
import java.util.Map;

public class CartShopping implements Cart {
    private Map<Product, Integer> products = new HashMap<>();
    private Inventory inventory;

    public CartShopping(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String addProduct(String productName, int quantity) {
        if (isProductAvailable(productName, quantity)) {
            Product product = inventory.findProductByName(productName).get();
            products.put(product, products.getOrDefault(product, 0) + quantity);
            return "Added " + quantity + " of " + product.getName() + " to cart";
        } else {
            return "Product " + productName + " is not available in the requested quantity";
        }
    }


    @Override
    public boolean isProductAvailable(String productName, int quantity) {
        return inventory.findProductByName(productName)
                .filter(product -> product.getQuantity() >= quantity)
                .isPresent();
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return products;
    }

    // Метод для получения общей стоимости товаров в корзине
    @Override
    public double getTotalPrice() {
        double totalSum = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            totalSum += entry.getKey().getPrice() * entry.getValue();
        }
        return totalSum;
    }
}
