package com.liferay.challenge.model;

import com.liferay.challenge.api.Product;

import java.io.Serializable;

public class Book extends Product implements Serializable {

    private long bookId;

    public Book(int quantity, double price, String type, boolean imported){
     super(quantity, price, type, imported);

    }


}
