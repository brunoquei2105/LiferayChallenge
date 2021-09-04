package com.liferay.challenge.model;

import com.liferay.challenge.api.Product;

import java.io.Serializable;

public class Pill extends Product implements Serializable {

    private long pillId;

    public Pill(int quantity, double price, String type, boolean imported) {
        super(quantity, price, type, imported);
    }
}
