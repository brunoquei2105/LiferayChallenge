package com.liferay.challenge.web;

import com.liferay.challenge.api.model.*;
import com.liferay.challenge.api.persistence.ConnectionFactory;
import com.liferay.challenge.service.Constants.ProductConstants;
import com.liferay.challenge.service.Constants.ProductTaxConstant;
import com.liferay.challenge.service.ProducTypeValidator;
import com.liferay.challenge.service.ProductPricePlusTaxCalculator;
import com.liferay.challenge.service.ProductSalesTaxCalculator;

import java.sql.SQLException;
import java.util.*;

public class Input3View {
    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.getConnection();

        Product product = null;
        List<Product> productCar = new ArrayList<>();

        System.out.println("---LIFERAY CHALLENGE---");

        System.out.print("Enter Product Name: ");
        String importedPerfume = input.next();
        if(Objects.equals(importedPerfume, ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC)){
            product = new Perfume();
            product.setName(importedPerfume);
            ProducTypeValidator.validatorType(product);
        }
        System.out.print("Product is Imported [y/n] ?  ");
        String imported = input.next();
        if (Objects.equals(imported, "y")){
            assert product != null;
            product.setImported(ProductConstants.PRODUCT_IMPORTED);
        }
        else {
            assert product != null;
            product.setImported(ProductConstants.PRODUCT_NOT_IMPORTED);

        }
        System.out.print("Enter Product Quantity: ");
        int perfumeQuantity = input.nextInt();
        product.setQuantity(perfumeQuantity);

        System.out.print("Enter Product Price U$: ");
        double priceImported = input.nextDouble();
        product.setPrice(priceImported );
        double perfumeTax = ProductSalesTaxCalculator.basicImportedSalesTax(product);
        double perfumeWithTax = ProductPricePlusTaxCalculator.pricePlusImportedBasicTax(priceImported );
        product.setPrice(perfumeWithTax);

        productCar.add(product);


        System.out.print("Enter Product Name: ");
        String perfume = input.next();
        if(Objects.equals(importedPerfume, ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC)){
            product = new Perfume();
            product.setName(perfume);
            ProducTypeValidator.validatorType(product);
        }
        System.out.print("Product is Imported [y/n] ?  ");
        String notImported = input.next();
        if (Objects.equals(notImported, "y")){
            product.setImported(ProductConstants.PRODUCT_IMPORTED);
        }
        else {
            product.setImported(ProductConstants.PRODUCT_NOT_IMPORTED);

        }

        System.out.print("Enter Product Quantity: ");
        int perfumeQuantity2 = input.nextInt();
        product.setQuantity(perfumeQuantity2);

        System.out.print("Enter Product Price U$: ");
        double priceNotImported = input.nextDouble();
        product.setPrice(priceNotImported);
        double perfumeTaxNotImported = ProductSalesTaxCalculator.basicSalestax(product);
        double perfumeNotImportedWithTax = ProductPricePlusTaxCalculator.pricePlusBasicTax(priceNotImported);
        product.setPrice(perfumeNotImportedWithTax);

        productCar.add(product);

        System.out.print("Enter Product Name: ");
        String productName = input.next();
        if(Objects.equals(productName , ProductConstants.PRODUCT_ENTRY_TYPE_MEDICINE)){
            product = new Pill();
            product.setName(productName );
            ProducTypeValidator.validatorType(product);
        }

        System.out.print("Enter Product Quantity: ");
        int packetPillQuantity = input.nextInt();
        product.setQuantity(packetPillQuantity);

        System.out.print("Enter Product Price U$: ");
        double pricePill = input.nextDouble();
        product.setPrice(pricePill);
        double pillTax =  ProductTaxConstant.PRODUCT_FREE_TAX;
        double pillWithTax = ProductPricePlusTaxCalculator.priceWithFreeTax(pricePill);
        product.setPrice(pillWithTax);
        productCar.add(product);


        System.out.print("Enter Product Name: ");
        String nameProduct1 = input.next();
        if (Objects.equals(nameProduct1, ProductConstants.PRODUCT_ENTRY_TYPE_FOOD)){
            product = new Chocolate();
            product.setName(nameProduct1);
            ProducTypeValidator.validatorType(product);
        }

        System.out.print("Product is Imported [y/n] ?  ");
        String chocolateImported = input.next();
        if (Objects.equals(chocolateImported , "y")){
            product.setImported(ProductConstants.PRODUCT_IMPORTED);
        }
        else {
            product.setImported(ProductConstants.PRODUCT_NOT_IMPORTED);

        }

        System.out.print("Enter Product Quantity: ");
        int productQuantity1 = input.nextInt();
        product.setQuantity(productQuantity1);

        System.out.print("Enter Product Price U$: ");
        double price = input.nextDouble();
        product.setPrice(price);
        double chocolateTax = ProductSalesTaxCalculator.importedSalesTax(product);
        double chocolateWithTax = ProductPricePlusTaxCalculator.pricePlusImportedTax(price);
        product.setPrice(chocolateWithTax);
        productCar.add(product);

        double totalTax = perfumeTax + perfumeTaxNotImported + pillTax + chocolateTax;
        double totalPrice = perfumeWithTax + perfumeNotImportedWithTax + pillWithTax + chocolateWithTax ;

        System.out.println();
        System.out.println("___Invoice___");

        for (Product prod : productCar){
            System.out.printf(prod.getQuantity() + " " + prod.getName() + ": " + " %.2f", prod.getPrice());
            System.out.println();
        }
        System.out.printf("Sales Tax: " + "%.2f%n",  totalTax);
        System.out.printf("Total: "+ "%.2f%n", totalPrice);

    }
}
