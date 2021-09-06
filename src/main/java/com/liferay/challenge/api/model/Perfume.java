package com.liferay.challenge.api.model;

import java.io.Serializable;

/**
@author: Bruno Queiroz
 */

public class Perfume extends Product implements Serializable {

    private long perfumeId;

    public Perfume(){}

    public Perfume(int quantity, double price, String type, String imported) {
        super(quantity, price, type, imported );
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "quantity=" + getQuantity()+
                ", price=" + getPrice() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", imported='" + getImported() + '\'' +
                '}';
    }
}
