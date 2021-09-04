package com.liferay.challenge.model;

import com.liferay.challenge.api.Product;

import java.io.Serializable;

public class Perfume extends Product implements Serializable {

    private long perfumeId;

    public Perfume(int quantity, double price, String type, boolean imported) {
        super(quantity, price, type, imported );
    }
}
