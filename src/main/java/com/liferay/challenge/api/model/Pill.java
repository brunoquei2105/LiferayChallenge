package com.liferay.challenge.api.model;

import java.io.Serializable;

/**
 * @author: Bruno Queiroz
 */
public class Pill extends Product implements Serializable {

    private long pillId;

    public Pill(){}

    public Pill(int quantity, double price, String type, String imported) {

        super(quantity, price, type, imported);
    }

    @Override
    public String toString() {
        return "Headache Pills{" +
                "quantity=" + getQuantity()+
                ", price=" + getPrice() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", imported='" + getImported() + '\'' +
                '}';
    }
}
