package org.example.payment;

import org.example.shoping.Cart;
import org.example.shoping.Order;

public class CreditCard implements PaySystem {
    Cart cartShopping;

    public CreditCard(Cart cartShopping) {
        this.cartShopping = cartShopping;
    }

    @Override
    public void pay() {
        System.out.println("Paymeny for " + cartShopping.getTotalPrice() + "rub. is in processing...");
    }
}
