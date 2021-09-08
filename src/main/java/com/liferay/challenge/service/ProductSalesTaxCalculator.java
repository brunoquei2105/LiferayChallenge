package com.liferay.challenge.service;

import com.liferay.challenge.api.model.Product;
import com.liferay.challenge.service.Constants.ProductConstants;
import com.liferay.challenge.service.Constants.ProductTaxConstant;

import java.util.Objects;

/**
 * @author: Bruno Queiroz
 */

public class ProductSalesTaxCalculator {

    public ProductSalesTaxCalculator(){}


    public static double basicSalestax(Product product) {
        double totalBasicTaxValue = 0;
        if(Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC) ||
                Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC)){

          totalBasicTaxValue = product.getPrice() * ProductTaxConstant.BASIC_TAX ;
        }
        else {
            return ProductTaxConstant.EMPTY_TAX;
        }
        return totalBasicTaxValue;
    }


    public static double importedSalesTax(Product product) {
        double totalImportedTaxValue = 0;
        if (Objects.equals(product.getImported(), ProductConstants.PRODUCT_IMPORTED)) {
            totalImportedTaxValue = product.getPrice() * ProductTaxConstant.IMPORTED_TAX;
        }
        return  totalImportedTaxValue;
    }

    public static double basicImportedSalesTax(Product product) {
        double totalBasicImportedSalesTax = 0;
        if(Objects.equals(product.getImported(), ProductConstants.PRODUCT_IMPORTED) &&
                (Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC) ||
                 Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC))) {

                totalBasicImportedSalesTax = product.getPrice() * ProductTaxConstant.IMPORTED_COSMETIC_MUSIC_TAX;


        }
        else if (Objects.equals(product.getImported(), ProductConstants.PRODUCT_IMPORTED) &&
                    (Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_BOOK) ||
                     Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_FOOD) ||
                     Objects.equals(product.getType(), ProductConstants.PRODUCT_ENTRY_TYPE_MEDICINE))){

                return importedSalesTax(product);
            }

        return totalBasicImportedSalesTax;

    }
}
