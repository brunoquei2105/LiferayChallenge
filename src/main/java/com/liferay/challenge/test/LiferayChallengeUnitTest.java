package com.liferay.challenge.test;

import com.liferay.challenge.api.model.Perfume;
import com.liferay.challenge.api.model.Product;
import com.liferay.challenge.service.ProductPricePlusTaxCalculator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LiferayChallengeUnitTest extends TestCase {

    @Test
    public void productPricePlusTaxCalculatorTest(Double price){

        Product perfume = new Perfume(1, 10.0, "perfume","true");
        ProductPricePlusTaxCalculator.pricePlusBasicTax(perfume.getPrice());
        ProductPricePlusTaxCalculator.pricePlusImportedBasicTax(perfume.getPrice());

        Assert.assertEquals(11.00, perfume.getPrice(), 0.0);
        Assert.assertEquals(11.50, perfume.getPrice(), 0.0);


    }
}
