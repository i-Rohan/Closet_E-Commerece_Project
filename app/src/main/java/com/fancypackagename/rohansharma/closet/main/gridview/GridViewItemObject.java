package com.fancypackagename.rohansharma.closet.main.gridview;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class GridViewItemObject {
    private String productName, sellerName, price;

    public GridViewItemObject(String productName, String sellerName, String price) {
        this.productName = productName;
        this.sellerName = sellerName;
        this.price = price;
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
}
