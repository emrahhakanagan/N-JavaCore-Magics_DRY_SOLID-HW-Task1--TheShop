package org.example.inventory;

import org.example.shoping.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Inventory {
    private List<Product> products = new ArrayList<>();

//    private Cart cartShopping;


    // Метод для добавления продукта в инвентарь
    public void addProduct(String name, double price, int quantity) {
        Optional<Product> existingProduct = findProductByName(name);

        if (existingProduct.isPresent()) {
            // Если продукт уже есть, увеличиваем его количество
            Product product = existingProduct.get();
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println("Increased quantity for product: " + name);
        } else {
            // Если продукта нет, добавляем новый продукт
            int id = products.isEmpty() ? 1 : products.get(products.size() - 1).getId() + 1;
            products.add(new Product(id, name, price, quantity));
            System.out.println("Added new product: " + name);
        }
    }

    public Optional<Product> findProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
    }

    public void showProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void reduceProduct(Cart cartShopping) {
        for (Map.Entry<Product, Integer> entry : cartShopping.getProducts().entrySet()) {
            Product cartProduct = entry.getKey();
            int cartQuantity = entry.getValue();

            findProductByName(cartProduct.getName()).ifPresent(inventoryProduct -> {
                int newQuantity = inventoryProduct.getQuantity() - cartQuantity;
                inventoryProduct.setQuantity(Math.max(newQuantity, 0));  // Предотвращаем отрицательное количество
            });
        }
    }

}
