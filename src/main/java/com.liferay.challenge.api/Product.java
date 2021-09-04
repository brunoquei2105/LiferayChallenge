package com.liferay.challenge.api;

public abstract class Product {

    private int quantity;
    private double price;
    private String type;
    private boolean imported;

    public Product(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;

    }
    public  Product(int quantity, double price, String type, boolean imported){
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.imported = imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}



