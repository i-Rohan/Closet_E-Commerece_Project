package com.fancypackagename.rohansharma.closet.main;

/**
 * Created by Rohan Sharma on 17-12-2016.
 */

public class Cart {
    String productName, sellerName, size, color;
    int quantity;
    double price;

    public Cart(String productName, String sellerName, String size, String color, int quantity, double price) {
        this.productName = productName;
        this.sellerName = sellerName;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }
}
