package com.iks.commerce.cart_tax.constant;

/**
 * The type CartTaxLoggingConstants.
 * Contains all log messages related to Cart Tax operations.
 */
public final class CartTaxLoggingConstants {

    private CartTaxLoggingConstants() {
        // Private constructor to prevent instantiation
    }

    /**
     * The constant LOG_ADDING_CART_TAX.
     */
    public static final String LOG_ADDING_CART_TAX =
            "Adding a new cart tax entry with cartId: {}, cartItemId: {}";

    /**
     * The constant LOG_SUCCESS_ADD_CART_TAX.
     */
    public static final String LOG_SUCCESS_ADD_CART_TAX =
            "Successfully added cart tax entry with cartId: {}, cartItemId: {}";

    /**
     * The constant LOG_FETCHING_CART_TAX.
     */
    public static final String LOG_FETCHING_CART_TAX =
            "Fetching cart tax entry with ID: {}";

    /**
     * The constant LOG_FOUND_CART_TAX.
     */
    public static final String LOG_FOUND_CART_TAX =
            "Cart tax entry with ID: {} found";

    /**
     * The constant LOG_NOT_FOUND_CART_TAX.
     */
    public static final String LOG_NOT_FOUND_CART_TAX =
            "Cart tax entry with ID: {} not found";

    /**
     * The constant LOG_UPDATING_CART_TAX.
     */
    public static final String LOG_UPDATING_CART_TAX =
            "Updating cart tax entry with ID: {}";

    /**
     * The constant LOG_SUCCESS_UPDATE_CART_TAX.
     */
    public static final String LOG_SUCCESS_UPDATE_CART_TAX =
            "Successfully updated cart tax entry with ID: {}";

    /**
     * The constant LOG_ERROR_UPDATE_CART_TAX.
     */
    public static final String LOG_ERROR_UPDATE_CART_TAX =
            "Cart tax entry with ID: {} not found for update";

    /**
     * The constant LOG_DELETING_CART_TAX.
     */
    public static final String LOG_DELETING_CART_TAX =
            "Deleting cart tax entry with ID: {}";

    /**
     * The constant LOG_SUCCESS_DELETE_CART_TAX.
     */
    public static final String LOG_SUCCESS_DELETE_CART_TAX =
            "Successfully deleted cart tax entry with ID: {}";

    /**
     * The constant LOG_ERROR_DELETE_CART_TAX.
     */
    public static final String LOG_ERROR_DELETE_CART_TAX =
            "Cart tax entry with ID: {} not found for deletion";
}
