package com.iks.commerce.cart_tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * The type Return order application.
 * This is the entry point of
 * the Spring Boot application for managing return orders.
 */
@EnableMongoRepositories(basePackages = "com.iks.commerce.cart_tax.repository")
@SpringBootApplication
public class CartTaxApplication {
    //Private constructor to prevent instantiation
    protected CartTaxApplication() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(CartTaxApplication.class, args);
    }

}
