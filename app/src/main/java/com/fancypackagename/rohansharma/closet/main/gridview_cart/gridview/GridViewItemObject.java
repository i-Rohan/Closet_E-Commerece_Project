package com.fancypackagename.rohansharma.closet.main.gridview_cart.gridview;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class GridViewItemObject {
    private double price;
    private int quantity;
    private String productName, image, sellerName, size, color;

    public GridViewItemObject(String productName, String sellerName, String size, String color, int quantity, double price, String image) {
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.sellerName = sellerName;
        this.size = size;
        this.color = color;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}