package com.liferay.challenge.service;

import com.liferay.challenge.api.model.Product;
import com.liferay.challenge.service.Constants.ProductConstants;

import java.util.Objects;

public class ProducTypeValidator {


    public static void validatorType(Product product){
        if (Objects.equals(product.getName(), ProductConstants.PRODUCT_ENTRY_TYPE_BOOK)){
               product.setType(ProductConstants.PRODUCT_ENTRY_TYPE_BOOK);
        }
        else if (Objects.equals(product.getName(), ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC)){
            product.setType(ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC);
        }
        else if(Objects.equals(product.getName(), ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC)){
            product.setType(ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC);
        }
        else if(Objects.equals(product.getName(), ProductConstants.PRODUCT_ENTRY_TYPE_FOOD)){
            product.setType(ProductConstants.PRODUCT_ENTRY_TYPE_FOOD);
        }
        else if(Objects.equals(product.getName(),ProductConstants.PRODUCT_ENTRY_TYPE_MEDICINE)){
            product.setType(ProductConstants.PRODUCT_ENTRY_TYPE_MEDICINE);
        }
    }
}
