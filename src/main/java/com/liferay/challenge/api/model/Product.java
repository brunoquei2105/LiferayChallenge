package com.liferay.challenge.api.model;

/**
@author: Bruno Queiroz
 */

public abstract class Product {

    private int quantity;
    private double price;
    private String name;
    private String type;
    private String imported;

    public Product(){}

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }
    public Product(int quantity, double price, String type, String imported){
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

    public String getImported() {return imported;}

    public void setImported(String imported) {this.imported = imported;}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imported='" + imported + '\'' +
                '}';
    }
}



