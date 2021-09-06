package com.liferay.challenge.web;

import com.liferay.challenge.api.model.Book;
import com.liferay.challenge.api.model.CdMusic;
import com.liferay.challenge.api.model.Chocolate;
import com.liferay.challenge.api.model.Product;


import com.liferay.challenge.api.persistence.ConnectionFactory;
import com.liferay.challenge.service.Constants.ProductTaxConstant;
import com.liferay.challenge.service.ProducTypeValidator;
import com.liferay.challenge.service.Constants.ProductConstants;
import com.liferay.challenge.service.ProductPricePlusTaxCalculator;
import com.liferay.challenge.service.ProductSalesTaxCalculator;

import java.sql.SQLException;
import java.util.*;

public class Input1View {
    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.getConnection();

        Product product = null;
        List<Product> productCar = new ArrayList<>();

        System.out.println("---LIFERAY CHALLENGE---");
        System.out.println("Input 1");

        System.out.print("Enter Product Name: ");
        String productName = input.next();
        if(Objects.equals(productName , ProductConstants.PRODUCT_ENTRY_TYPE_BOOK)){
            product = new Book();
            product.setName(productName );
            ProducTypeValidator.validatorType(product);
        }
        System.out.print("Enter Product Quantity: ");
        int quantity = input.nextInt();
        product.setQuantity(quantity);

        System.out.print("Enter Product Price U$: ");
        double price = input.nextDouble();
        product.setPrice(price);
        ProductSalesTaxCalculator.basicSalestax(product);

        productCar.add(product);

        System.out.print("Enter Product Name: ");
        String productName2 = input.next();
        if(Objects.equals(productName2, ProductConstants.PRODUCT_ENTRY_TYPE_MUSIC)){
            product = new CdMusic();
            product.setName(productName2);
            ProducTypeValidator.validatorType(product);
        }
        System.out.print("Enter Product Quantity: ");
        int qnt  = input.nextInt();
        product.setQuantity(qnt);

        System.out.print("Enter Product Price U$: ");
        double priceProd = input.nextDouble();
        double cdTax = priceProd * ProductTaxConstant.BASIC_TAX;
        product.setPrice(ProductPricePlusTaxCalculator.pricePlusBasicTax(priceProd));
        double priceWithTax = product.getPrice();

        productCar.add(product);

        System.out.print("Enter Product Name: ");
        String productName3 = input.next();
        if(Objects.equals(productName3, ProductConstants.PRODUCT_ENTRY_TYPE_FOOD)){
            product = new Chocolate();
            product.setName(productName3);
            ProducTypeValidator.validatorType(product);
        }
        System.out.print("Enter Product Quantity: ");
        int qnt2  = input.nextInt();
        product.setQuantity(qnt2);

        System.out.print("Enter Product Price U$: ");
        double price3 = input.nextDouble();
        product.setPrice(price3);
        ProductSalesTaxCalculator.basicSalestax(product);

        productCar.add(product);

        System.out.println();
        System.out.println("___Invoice___");

        double totalCarPrice = price + priceWithTax + price3;
        for(Product prod: productCar){
            System.out.printf(prod.getQuantity() + " " + prod.getName() + ": " + " %.2f", prod.getPrice());
            System.out.println();
        }

        System.out.printf("Sales Tax: " + "%.2f%n",  cdTax);
        System.out.printf("Total: "+ "%.2f%n", totalCarPrice);

        input.close();





    }
}
