package com.liferay.challenge.api.model;

import java.io.Serializable;

/**
@author: Bruno Queiroz
 */

public class Book extends Product implements Serializable {

    public Book(){}

    public  Book(String name, int quantity, double price){
        super(name, quantity, price);
    }

    public Book(int quantity, double price, String type, String imported){
     super(quantity, price, type, imported);

    }
    @Override
    public String toString() {
        return "Book{" +
                "quantity=" + getQuantity()+
                ", price=" + getPrice() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", imported='" + getImported() + '\'' +
                '}';
    }
}
