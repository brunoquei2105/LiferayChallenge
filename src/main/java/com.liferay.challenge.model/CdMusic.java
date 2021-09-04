package com.liferay.challenge.model;

import com.liferay.challenge.api.Product;

import java.io.Serializable;

public class CdMusic extends Product implements Serializable {

    private long cdMusicId;

    public CdMusic(int quantity, double price, String type, boolean imported) {
        super(quantity, price, type, imported);
    }
}
