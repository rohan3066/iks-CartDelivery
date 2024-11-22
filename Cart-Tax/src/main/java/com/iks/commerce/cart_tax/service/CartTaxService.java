package com.iks.commerce.cart_tax.service;


import com.iks.commerce.cart_tax.constant.CartTaxLoggingConstants;
import com.iks.commerce.cart_tax.exception.ResourceNotFound;
import com.iks.commerce.cart_tax.model.CartTax;
import com.iks.commerce.cart_tax.repository.CartTaxRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The type Cart tax service.
 * This service class handles the business logic for managing cart tax entries.
 */
@Service
public class CartTaxService {
    /**
     * The logger instance used for logging important events
     * related to cart tax operations in the {@link CartTaxService}.
     *
     * <p>
     * This logger is initialized using {@link LoggerFactory} and logs messages
     * related to various operations such as adding, updating, retrieving, and
     * deleting cart tax entries. It also logs success and error messages to
     * ensure
     * proper traceability and auditing.
     * </p>
     *
     * <p><strong>Example Log Statements:</strong></p>
     * <ul>
     *   <li>Adding a new cart tax entry.</li>
     *   <li>Fetching a cart tax entry by ID.</li>
     *   <li>Logging an error when an entry is not found.</li>
     * </ul>
     *
     * @see LoggerFactory
     * @see CartTaxLoggingConstants
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CartTaxService.class);

    /**
     * The repository responsible for performing CRUD operations
     * on {@link CartTax} entities in the MongoDB database.
     *
     * <p>
     * This repository provides methods for saving, finding, updating,
     * and deleting cart tax entries. It interacts directly with the
     * underlying MongoDB datastore, abstracting the data access layer.
     * The {@link CartTaxService} uses this repository to perform database
     * operations as part of its business logic.
     * </p>
     *
     * <p><strong>Operations Performed:</strong></p>
     * <ul>
     *   <li>Saving a new cart tax entry to the database.</li>
     *   <li>Fetching a cart tax entry by its unique ID.</li>
     *   <li>Deleting an existing cart tax entry.</li>
     * </ul>
     *
     * @see CartTaxRepository
     * @see CartTax
     */
    private final CartTaxRepository cartTaxRepository;

    /**
     * Instantiates a new Cart tax service.
     *
     * @param cartTaxRepository1 the cart tax repository
     */
    public CartTaxService(final CartTaxRepository cartTaxRepository1) {
        this.cartTaxRepository = cartTaxRepository1;
    }

    /**
     * Adds a new cart tax entry.
     *
     * @param cartTax the cart tax entry to be added
     * @return the added cart tax entry
     */
    public CartTax addCartTax(final CartTax cartTax) {
        cartTax.setCreatedDate(LocalDateTime.now());
        LOGGER.info(CartTaxLoggingConstants.LOG_ADDING_CART_TAX,
                cartTax.getCartId(), cartTax.getCartItemId());
        CartTax savedCartTax = cartTaxRepository.save(cartTax);
        LOGGER.info(CartTaxLoggingConstants.LOG_SUCCESS_ADD_CART_TAX,
                savedCartTax.getCartId(), savedCartTax.getCartItemId());
        return savedCartTax;
    }

    /**
     * Retrieves a cart tax entry by its ID.
     *
     * @param id the ID of the cart tax entry to be retrieved
     * @return an Optional containing the found cart tax entry,
     * or an empty Optional if not found
     */
    public Optional<CartTax> getCartTaxById(final String id) {
        LOGGER.info(CartTaxLoggingConstants.LOG_FETCHING_CART_TAX, id);
        Optional<CartTax> cartTax = cartTaxRepository.findById(id);
        if (cartTax.isPresent()) {
            LOGGER.info(CartTaxLoggingConstants.LOG_FOUND_CART_TAX, id);
        } else {
            LOGGER.warn(CartTaxLoggingConstants.LOG_NOT_FOUND_CART_TAX, id);
        }
        return cartTax;
    }

    /**
     * Updates an existing cart tax entry.
     *
     * @param id             the ID of the cart tax entry to be updated
     * @param updatedCartTax the updated cart tax information
     * @return the updated cart tax entry
     * @throws ResourceNotFound if no cart tax entry is found with the
     *                          specified ID
     */
    public CartTax
    updateCartTax(final String id, final CartTax updatedCartTax) {
        LOGGER.info(CartTaxLoggingConstants.LOG_UPDATING_CART_TAX, id);
        Optional<CartTax> existingCartTax = cartTaxRepository.findById(id);
        if (existingCartTax.isPresent()) {
            LOGGER.info(CartTaxLoggingConstants
                    .LOG_SUCCESS_UPDATE_CART_TAX, id);
            return cartTaxRepository.save(updatedCartTax);
        } else {
            LOGGER.error(CartTaxLoggingConstants.LOG_ERROR_UPDATE_CART_TAX, id);
            throw new
                    ResourceNotFound("Cart tax entry not found with ID: " + id);
        }
    }

    /**
     * Deletes a cart tax entry by its ID.
     *
     * @param id the ID of the cart tax entry to be deleted
     * @throws ResourceNotFound if no cart tax entry is found with
     *                          the specified ID
     */
    public void deleteCartTax(final String id) {
        LOGGER.info(CartTaxLoggingConstants.LOG_DELETING_CART_TAX, id);
        Optional<CartTax> cartTax = getCartTaxById(id);
        if (cartTax.isPresent()) {
            cartTaxRepository.delete(cartTax.get());
            LOGGER.info(CartTaxLoggingConstants
                    .LOG_SUCCESS_DELETE_CART_TAX, id);
        } else {
            LOGGER.error(CartTaxLoggingConstants
                    .LOG_ERROR_DELETE_CART_TAX, id);
            throw new
                    ResourceNotFound("Cart tax entry not found with ID: " + id);
        }
    }
}
