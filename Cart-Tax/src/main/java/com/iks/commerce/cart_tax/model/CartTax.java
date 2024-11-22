package com.iks.commerce.cart_tax.model;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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

    /**
     * The minimum length for the tax name.
     */
    private static final int NAME_MIN_LENGTH = 3;

    /**
     * The maximum length for the tax name.
     */
    private static final int NAME_MAX_LENGTH = 100;

    /**
     * The maximum length for the tax description.
     */
    private static final int DESCRIPTION_MAX_LENGTH = 250;
    /**
     * The unique identifier for this cart tax entry.
     */
    @Id
    private String id;
    /**
     * The identifier for the associated cart.
     */
    @NotBlank(message = "Cart ID cannot be empty")
    private String cartId;
    /**
     * The identifier for the associated cart item.
     */
    @NotBlank(message = "Cart Item ID cannot be empty")
    private String cartItemId;
    /**
     * The name of the tax.
     */
    @NotBlank(message = "Name cannot be empty")
    @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH,
            message = "Name must be between " + NAME_MIN_LENGTH + " and "
                    + NAME_MAX_LENGTH + " characters")
    private String name;
    /**
     * A brief description of the tax.
     */
    @NotEmpty(message = "Description must contain at least one value")
    @NotNull(message = "Description cannot be empty")
    @Size(max = DESCRIPTION_MAX_LENGTH, message = "Description cannot exceed "
            + DESCRIPTION_MAX_LENGTH + " characters")
    private String description;
    /**
     * The tax rate applied to the cart item.
     */
    @NotNull(message = "Tax rate is required")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "Tax rate must be greater than 0")
    private double taxRate;
    /**
     * The types of tax applied, represented as an array of strings.
     */
    @NotEmpty(message = "Tax type must contain at least one value")
    private String[] taxType;
    /**
     * The date and time when the cart tax entry was created.
     */
    @PastOrPresent(message = "Created date must be in the past or present")
    private LocalDateTime createdDate;

    public void setCreatedDate(@PastOrPresent(message = "Created date must be in the past or present") LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * The user or system that created this cart tax entry.
     */
    @NotBlank(message = "Created By cannot be empty")
    private String createdBy;
    /**
     * The date and time when the tax was calculated.
     */
    @PastOrPresent(message = "Tax calculation date must be in the past "
            +
            "or present")
    private LocalDateTime taxCalculationDate;

    /**
     * Instantiates a new Cart tax with specified attributes.
     *
     * @param id1          the unique identifier for this cart tax entry
     * @param cartId1      the identifier for the associated cart
     * @param cartItemId1  the identifier for the associated cart item
     * @param name1        the name of the tax
     * @param description1 a brief description of the tax
     * @param taxRate1     the tax rate applied to the cart item
     * @param taxType1     the types of tax applied, represented
     *                     as an array of strings
     */
    public CartTax(final String id1, final String cartId1,
                   final String cartItemId1, final String name1,
                   final String description1, final double taxRate1,
                   final String[] taxType1) {
        this.id = id1;
        this.cartId = cartId1;
        this.cartItemId = cartItemId1;
        this.name = name1;
        this.description = description1;
        this.taxRate = taxRate1;
        this.taxType = taxType1;
    }


    /**
     * Instantiates a new Cart tax with default values.
     */
    public CartTax() {
        // Default constructor
    }

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
     * @param cartId1 the cart identifier
     */
    public void setCartId(final String cartId1) {
        this.cartId = cartId1;
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
     * @param cartItemId1 the cart item identifier
     */
    public void setCartItemId(final String cartItemId1) {
        this.cartItemId = cartItemId1;
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
     * @param name1 the name of the tax
     */
    public void setName(final String name1) {
        this.name = name1;
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
     * @param description1 the description of the tax
     */
    public void setDescription(final String description1) {
        this.description = description1;
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
     * @param taxRate1 the tax rate
     */
    public void setTaxRate(final double taxRate1) {
        this.taxRate = taxRate1;
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
     * @param taxType1 the array of tax types
     */
    public void setTaxType(final String[] taxType1) {
        this.taxType = taxType1;
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
     * @param createdBy1 the identifier of the creator
     */
    public void setCreatedBy(final String createdBy1) {
        this.createdBy = createdBy1;
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
     * @param taxCalculationDate1 the tax calculation date
     */
    public void setTaxCalculationDate(final LocalDateTime taxCalculationDate1) {
        this.taxCalculationDate = taxCalculationDate1;
    }

    /**
     * Returns a string representation of the CartTax object.
     * This can be useful for debugging and logging purposes.
     *
     * @return a string representation of the cart tax
     */
    @Override
    public String toString() {
        return "CartTax{"
                +
                "id='" + id + '\''
                +
                ", cartId='" + cartId + '\''
                +
                ", cartItemId='" + cartItemId + '\''
                +
                ", name='" + name + '\''
                +
                ", description='" + description + '\''
                +
                ", taxRate=" + taxRate
                +
                ", taxType=" + Arrays.toString(taxType)
                +
                ", createdDate=" + createdDate
                +
                ", createdBy='" + createdBy + '\''
                +
                ", taxCalculationDate=" + taxCalculationDate
                +
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof CartTax)) {
            return false;
        }
        CartTax cartTax = (CartTax) o;
        return Double.compare(cartTax.taxRate, taxRate) == 0
                &&
                id.equals(cartTax.id)
                &&
                cartId.equals(cartTax.cartId)
                &&
                cartItemId.equals(cartTax.cartItemId)
                &&
                name.equals(cartTax.name)
                &&
                description.equals(cartTax.description)
                &&
                Arrays.equals(taxType, cartTax.taxType)
                &&
                createdDate.equals(cartTax.createdDate)
                &&
                createdBy.equals(cartTax.createdBy)
                &&
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

    /**
     * Sets the created date for the CartTax object.
     *
     *  the date and time when the cart tax entry was created
     */

}

