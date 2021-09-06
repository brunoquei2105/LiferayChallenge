package com.liferay.challenge.web;

import com.liferay.challenge.api.model.Chocolate;
import com.liferay.challenge.api.model.Perfume;
import com.liferay.challenge.api.model.Product;
import com.liferay.challenge.api.persistence.ConnectionFactory;
import com.liferay.challenge.service.Constants.ProductConstants;
import com.liferay.challenge.service.Constants.ProductTaxConstant;
import com.liferay.challenge.service.ProducTypeValidator;

import java.sql.SQLException;
import java.util.*;

public class Input2View {
    public static void main(String[] args) throws SQLException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.getConnection();

        Product product = null;
        List<Product> productCar = new ArrayList<>();

        System.out.println("---LIFERAY CHALLENGE---");
        System.out.println("Imported Products:");

        System.out.print("Enter Product Name: ");
        String nameProduct1 = input.next();
        if (Objects.equals(nameProduct1, ProductConstants.PRODUCT_ENTRY_TYPE_FOOD)){
            product = new Chocolate();
            product.setName(nameProduct1);
            ProducTypeValidator.validatorType(product);
        }

        System.out.print("Enter Product Quantity: ");
        int productQuantity1 = input.nextInt();
        product.setQuantity(productQuantity1);

        System.out.print("Enter Product Price U$: ");
        double price = input.nextDouble();
        product.setPrice(price);
        double chocolateTax = product.getPrice() * ProductTaxConstant.IMPORTED_TAX;
        double chocolateWithTax = product.getPrice() * ProductTaxConstant.PRICE_PLUS_IMPORTED_TAX;

        productCar.add(product);

        System.out.print("Enter Product Name: ");
        String nameProduct2 = input.next();
        if(Objects.equals(nameProduct2, ProductConstants.PRODUCT_ENTRY_TYPE_COSMETIC)){
            product = new Perfume();
            product.setName(nameProduct2);
            ProducTypeValidator.validatorType(product);
        }

        System.out.print("Enter Product Quantity: ");
        int productQuantity2 = input.nextInt();
        product.setQuantity(productQuantity2);

        System.out.print("Enter Product Price U$: ");
        double price2 = input.nextDouble();
        product.setPrice(price2);
        double perfumeTax = product.getPrice() * ProductTaxConstant.IMPORTED_COSMETIC_MUSIC_TAX;
        double perfumeWithTax = product.getPrice() * ProductTaxConstant.PRICE_PLUS_IMPORTED_AND_BASIC_TAX;

        productCar.add(product);

        double totalTax = chocolateTax + perfumeTax;
        double totalPrice = chocolateWithTax + perfumeWithTax;

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
