package com.liferay.challenge.model;

import com.liferay.challenge.api.Product;

import java.io.Serializable;

public class Chocolate extends Product implements Serializable {

    private long chocId;

    public Chocolate(int quantity, double price, String type, boolean imported) {
        super(quantity, price, type, imported);
    }
}

