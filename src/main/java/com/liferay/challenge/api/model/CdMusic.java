package com.liferay.challenge.api.model;

import java.io.Serializable;

/**
@author: Bruno Queiroz
 */

public class CdMusic extends Product implements Serializable {

    private long cdMusicId;

    public CdMusic(){}

    public CdMusic(int quantity, double price, String type, String imported) {

        super(quantity, price, type, imported);
    }

    @Override
    public String toString() {
        return "CD_MUSIC{" +
                "quantity=" + getQuantity()+
                ", price=" + getPrice() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", imported='" + getImported() + '\'' +
                '}';
    }
}
