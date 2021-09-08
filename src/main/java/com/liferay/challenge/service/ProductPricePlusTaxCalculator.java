package com.liferay.challenge.service;


import com.liferay.challenge.service.Constants.ProductTaxConstant;


public class ProductPricePlusTaxCalculator {


    public static double pricePlusBasicTax(double price){
        return price* ProductTaxConstant.PRICE_PLUS_BASIC_TAX;
    }

    public static double pricePlusImportedTax(double price){
        return price * ProductTaxConstant.PRICE_PLUS_IMPORTED_TAX;
   }

    public static double pricePlusImportedBasicTax(double price){
        return price * ProductTaxConstant.PRICE_PLUS_IMPORTED_AND_BASIC_TAX;
   }

    public static double priceWithFreeTax(double price){
        return price;
   }

}
