package com.liferay.challenge.test;

import com.liferay.challenge.api.model.*;
import com.liferay.challenge.service.ProductPricePlusTaxCalculator;
import com.liferay.challenge.service.ProductSalesTaxCalculator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LiferayChallengeUnitTest {

    @Test
    public void productPricePlusTaxCalculatorTest(){

        Product perfume = new Perfume(1, 10.0, "perfume","true");
        Product pill = new Pill(1, 20.00, "pill", "false");

        double return1 = ProductPricePlusTaxCalculator.pricePlusBasicTax(perfume.getPrice());
        double return2 = ProductPricePlusTaxCalculator.pricePlusImportedTax(perfume.getPrice());
        double return3 = ProductPricePlusTaxCalculator.pricePlusImportedBasicTax(perfume.getPrice());
        double return4 = ProductPricePlusTaxCalculator.priceWithFreeTax(pill.getPrice());

        Assert.assertEquals(11.00, return1, 0.0);
        Assert.assertEquals(10.50, return2, 0.0);
        Assert.assertEquals(11.50, return3, 0.0);
        Assert.assertEquals(20.00, return4, 0.0);


    }

    @Test
    public void productSalesTaxCalculatorTest(){

        Product cd = new CdMusic(1, 14.99, "cd", "false");
        Product perfume = new Perfume(1, 10.0, "perfume","true");
        Product book = new Book(1, 10.0, "book", "true");

        double return1 = ProductSalesTaxCalculator.basicSalestax(cd);
        double return2 = ProductSalesTaxCalculator.basicSalestax(book);
        double return3 = ProductSalesTaxCalculator.importedSalesTax(book);
        double return4 = ProductSalesTaxCalculator.basicImportedSalesTax(perfume);

        Assert.assertEquals(1.499, return1, 0.0);
        Assert.assertEquals(0.0, return2, 0.0);
        Assert.assertEquals(0.5, return3, 0.0);
        Assert.assertEquals(1.50, return4, 0.0);





    }
}
