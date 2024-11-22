package com.iks.commerce.cart_tax.repository;


import com.iks.commerce.cart_tax.model.CartTax;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface Cart tax repository.
 */
public interface CartTaxRepository extends MongoRepository<CartTax, String> {
}
