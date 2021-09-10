package com.liferay.challenge.api.model;

/**
 * @author: Bruno Queiroz.
 */

public class ProductBuilder {

    private int quantity;
    private double price;
    private String name;
    private String type;
    private boolean imported;



    public ProductBuilder(Builder builder){
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.name = builder.name;
        this.type = builder.type;
        this.imported = builder.imported;
    }

    public static class Builder{
        private final int quantity;
        private final double price;
        private String name;
        private String type;
        private boolean imported;

        public Builder(int quantity, double price){
            this.quantity = quantity;
            this.price = price;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setType(String type){
            this.type = type;
            return this;
        }
        public Builder isImported(boolean imported){
            this.imported = imported;
            return this;
        }
        public ProductBuilder build(){
            return new ProductBuilder(this);

        }

    }
    @Override
    public String toString() {
        return "ProductBuilder{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imported=" + imported +
                '}';
    }
}
