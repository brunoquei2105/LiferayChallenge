package com.liferay.challenge.api.model;

import java.io.Serializable;

/**
@author: Bruno Queiroz
 */

public class Chocolate extends Product implements Serializable {

    private long chocId;

    public Chocolate(){}

    public Chocolate(int quantity, double price, String type, String imported) {
        super(quantity, price, type, imported);
    }
    @Override
    public String toString() {
        return "Chocolate{" +
                "quantity=" + getQuantity()+
                ", price=" + getPrice() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", imported='" + getImported() + '\'' +
                '}';
    }
}

