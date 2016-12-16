package com.fancypackagename.rohansharma.closet.main.gridview;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class GridViewItemObject {
    private String productName, price,image,button, productId;

    public GridViewItemObject(String productName, String price, String Image,String button,String productId) {
        this.productName = productName;
        this.price = price;
        this.image = Image;
        this.button=button;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
}