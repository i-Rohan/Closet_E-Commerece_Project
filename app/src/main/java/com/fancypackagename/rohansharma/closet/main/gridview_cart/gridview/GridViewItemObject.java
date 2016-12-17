package com.fancypackagename.rohansharma.closet.main.gridview_cart.gridview;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class GridViewItemObject {
    double price;
    int quantity;
    private String productName, image, button, productId, sellerName, size;

    public GridViewItemObject(String productName, double price, String image, int quantity, String sellerName, String size) {
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.sellerName = sellerName;
        this.size = size;
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

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
}