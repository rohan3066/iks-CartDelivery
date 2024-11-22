package com.iks.commerce.cart_tax.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a cart tax entry in the system.
 * This class contains information related to tax applied to cart items,
 * including the tax rate, types of tax, and associated metadata.
 */
public class CartTax {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 100;
    private static final int DESCRIPTION_MAX_LENGTH = 250;

    @Id
    private String id;

    @NotBlank(message = "Cart ID cannot be empty")
    private String cartId;

    @NotBlank(message = "Cart Item ID cannot be empty")
    private String cartItemId;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH,
            message = "Name must be between " + NAME_MIN_LENGTH + " and "
                    + NAME_MAX_LENGTH + " characters")
    private String name;

    @NotEmpty(message = "Description must contain at least one value")
    @NotNull(message = "Description cannot be empty")
    @Size(max = DESCRIPTION_MAX_LENGTH, message = "Description cannot exceed "
            + DESCRIPTION_MAX_LENGTH + " characters")
    private String description;

    @NotNull(message = "Tax rate is required")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "Tax rate must be greater than 0")
    private double taxRate;

    @NotEmpty(message = "Tax type must contain at least one value")
    private String[] taxType;

    @PastOrPresent(message = "Created date must be in the past or present")
    private LocalDateTime createdDate;

    @NotBlank(message = "Created By cannot be empty")
    private String createdBy;

    @PastOrPresent(message = "Tax calculation date must be in the past " +
            "or present")
    private LocalDateTime taxCalculationDate;

    /**
     * Instantiates a new Cart tax with specified attributes.
     *
     * @param id          the unique identifier for this cart tax entry
     * @param cartId      the identifier for the associated cart
     * @param cartItemId  the identifier for the associated cart item
     * @param name        the name of the tax
     * @param description a brief description of the tax
     * @param taxRate     the tax rate applied to the cart item
     * @param taxType     the types of tax applied, represented as an array
     *                    of strings
     */
    public CartTax(final String id, final String cartId,
                   final String cartItemId, final String name,
                   final String description, final double taxRate,
                   final String[] taxType) {
        this.id = id;
        this.cartId = cartId;
        this.cartItemId = cartItemId;
        this.name = name;
        this.description = description;
        this.taxRate = taxRate;
        this.taxType = taxType;
        this.createdDate = LocalDateTime.now();
    }

    /**
     * Instantiates a new Cart tax with default values.
     */
    public CartTax() {
        // Default constructor
    }

    // Getters and Setters

    /**
     * Gets the unique identifier for this cart tax entry.
     *
     * @return the unique identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the identifier for the associated cart.
     *
     * @return the cart identifier
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * Sets the identifier for the associated cart.
     *
     * @param cartId the cart identifier
     */
    public void setCartId(final String cartId) {
        this.cartId = cartId;
    }

    /**
     * Gets the identifier for the associated cart item.
     *
     * @return the cart item identifier
     */
    public String getCartItemId() {
        return cartItemId;
    }

    /**
     * Sets the identifier for the associated cart item.
     *
     * @param cartItemId the cart item identifier
     */
    public void setCartItemId(final String cartItemId) {
        this.cartItemId = cartItemId;
    }

    /**
     * Gets the name of the tax.
     *
     * @return the name of the tax
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the tax.
     *
     * @param name the name of the tax
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the description of the tax.
     *
     * @return the description of the tax
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the tax.
     *
     * @param description the description of the tax
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the tax rate applied to the cart item.
     *
     * @return the tax rate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Sets the tax rate applied to the cart item.
     *
     * @param taxRate the tax rate
     */
    public void setTaxRate(final double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Gets the types of tax applied, represented as an array of strings.
     *
     * @return the array of tax types
     */
    public String[] getTaxType() {
        return taxType;
    }

    /**
     * Sets the types of tax applied.
     *
     * @param taxType the array of tax types
     */
    public void setTaxType(final String[] taxType) {
        this.taxType = taxType;
    }

    /**
     * Gets the date and time when the cart tax entry was created.
     *
     * @return the created date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Gets the user or system that created this cart tax entry.
     *
     * @return the identifier of the creator
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the user or system that created this cart tax entry.
     *
     * @param createdBy the identifier of the creator
     */
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the date and time when the tax was calculated.
     *
     * @return the tax calculation date
     */
    public LocalDateTime getTaxCalculationDate() {
        return taxCalculationDate;
    }

    /**
     * Sets the date and time when the tax was calculated.
     *
     * @param taxCalculationDate the tax calculation date
     */
    public void setTaxCalculationDate(final LocalDateTime taxCalculationDate) {
        this.taxCalculationDate = taxCalculationDate;
    }

    /**
     * Returns a string representation of the CartTax object.
     * This can be useful for debugging and logging purposes.
     *
     * @return a string representation of the cart tax
     */
    @Override
    public String toString() {
        return "CartTax{" +
                "id='" + id + '\'' +
                ", cartId='" + cartId + '\'' +
                ", cartItemId='" + cartItemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", taxRate=" + taxRate +
                ", taxType=" + Arrays.toString(taxType) +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", taxCalculationDate=" + taxCalculationDate +
                '}';
    }

    /**
     * Compares this CartTax object to another object for equality.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CartTax)) return false;
        CartTax cartTax = (CartTax) o;
        return Double.compare(cartTax.taxRate, taxRate) == 0 &&
                id.equals(cartTax.id) &&
                cartId.equals(cartTax.cartId) &&
                cartItemId.equals(cartTax.cartItemId) &&
                name.equals(cartTax.name) &&
                description.equals(cartTax.description) &&
                Arrays.equals(taxType, cartTax.taxType) &&
                createdDate.equals(cartTax.createdDate) &&
                createdBy.equals(cartTax.createdBy) &&
                taxCalculationDate.equals(cartTax.taxCalculationDate);
    }

    /**
     * Returns a hash code value for this CartTax object.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, cartId, cartItemId, name, description, taxRate,
                Arrays.hashCode(taxType), createdDate, createdBy,
                taxCalculationDate);
    }
}
