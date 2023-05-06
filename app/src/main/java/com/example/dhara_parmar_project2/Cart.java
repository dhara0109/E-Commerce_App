package com.example.dhara_parmar_project2;

public class Cart {

    private String cartImage;
    private String cartName;
    private String cartPrice;
    private String cartDefault;

    public Cart(String cartImage, String cartName, String cartPrice) {
        this.cartImage = cartImage;
        this.cartName = cartName;
        this.cartPrice = cartPrice;
        this.cartDefault = cartDefault;

    }
    public String getCartImage() {
        return cartImage;
    }
    public void setCartImage(String cartImage) {
        this.cartImage = cartImage;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public String getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(String cartPrice) {
        this.cartPrice = cartPrice;
    }

    public String getCartDefault() {
        return cartDefault;
    }

    public void setCartDefault(String cartDefault) {
        this.cartDefault = cartDefault;
    }



}
