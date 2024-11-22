package com.iks.commerce.cartdeliverygroup.constant;


/**
 * The type Cart delivery group constants.
 * This class holds all constant values used in the service and
 * controller layers.
 */
public class CartDeliveryGroupConstants {

    /**
     * Private constructor to prevent instantiation of the utility class.
     * This constructor is intentionally left private to ensure that the
     * utility class cannot be instantiated. Utility classes are designed
     * to hold static members and should not be created as objects.
     */
    protected CartDeliveryGroupConstants() {
    }

    /**
     * The constant LOG_INSERT_REQUEST.
     */
// Log Messages
    public static final String LOG_INSERT_REQUEST = "User requested to insert "
            + "a delivery group";
    /**
     * The constant LOG_INSERT_SUCCESS.
     */
    public static final String LOG_INSERT_SUCCESS = "Inserted a delivery "
            + "group successfully";
    /**
     * The constant LOG_GET_REQUEST.
     */
    public static final String LOG_GET_REQUEST = "user requested to "
            + "get a delivery group";
    /**
     * The constant LOG_UPDATE_REQUEST.
     */
    public static final String LOG_UPDATE_REQUEST = "User requested to update"
            + " cart delivery group";
    /**
     * The constant LOG_UPDATE_SUCCESS.
     */
    public static final String LOG_UPDATE_SUCCESS = "Successfully updated cart "
            + "delivery group";
    /**
     * The constant LOG_DELETE_REQUEST.
     */
    public static final String LOG_DELETE_REQUEST = "User requested to "
            + "delete cart delivery group with id: ";
    /**
     * The constant LOG_DELETE_SUCCESS.
     */
    public static final String LOG_DELETE_SUCCESS = "Successfully "
            + "deleted delivery group with id: ";
    /**
     * The constant LOG_DELETE_NOT_FOUND.
     */
    public static final String LOG_DELETE_NOT_FOUND = "Failed to delete "
            + "delivery group. ID not found: ";
    /**
     * The constant LOG_CART_NOT_FOUND.
     */
    public static final String LOG_CART_NOT_FOUND = "CartDeliveryGroup "
            + " not found";
    /**
     * The constant LOG_CART_FOUND.
     */
    public static final String LOG_CART_FOUND = "CartDeliveryGroup "
            + "found";

    /**
     * The constant ERROR_UPDATE_NOT_FOUND.
     */
// Error Messages
    public static final String ERROR_UPDATE_NOT_FOUND = "Cart "
            + "delivery group not found";
    /**
     * The constant ERROR_DELETE.
     */
    public static final String ERROR_DELETE = "Error occurred while "
            + "deleting cart delivery group";
    /**
     * The constant ERROR_AMOUNT_NEGATIVE.
     */
    public static final String ERROR_AMOUNT_NEGATIVE = "Amount should be "
            + "greater than 0";

    /**
     * The constant ZERO.
     */
// Other constants
    public static final double ZERO = 0.0;
}

