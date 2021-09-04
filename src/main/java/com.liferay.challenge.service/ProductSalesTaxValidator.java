package com.liferay.challenge.service;

import com.liferay.challenge.api.Product;

import java.util.Objects;


public class ProductSalesTaxValidator {

    public static double basicSalestax(Product product) {

        double totalBasicTaxValue = 0;
        if(Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC) ||
                Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC)){

          totalBasicTaxValue = product.getPrice() * ProductTaxConstant.BASIC_TAX;
        }
        else {
            return product.getPrice();
        }
        return totalBasicTaxValue;
    }


    public static double importedSalesTax(Product product) {
        double totalImportedTaxValue = 0;
        if (product.isImported() == ProductConstants.PRODUCT_IMPORTED) {
            totalImportedTaxValue = product.getPrice() * ProductTaxConstant.IMPORTED_TAX;
        }
        return  totalImportedTaxValue;
    }

    public static double basicImportedSalesTax(Product product) {
        double totalBasicImportedSalesTax = 0;
        if(product.isImported() == ProductConstants.PRODUCT_IMPORTED &&
                (Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC) ||
                 Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC))) {

                totalBasicImportedSalesTax = product.getPrice() * ProductTaxConstant.IMPORTED_COSMETIC_MUSIC_TAX;


        }
        else if (product.isImported() == ProductConstants.PRODUCT_IMPORTED &&
                    (Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_BOOK) ||
                     Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_FOOD) ||
                     Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_MEDICINE))){

                return importedSalesTax(product);
            }

        return totalBasicImportedSalesTax;

    }
}
