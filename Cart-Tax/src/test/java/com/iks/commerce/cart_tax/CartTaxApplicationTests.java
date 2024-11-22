package com.iks.commerce.cart_tax;

import com.iks.commerce.cart_tax.model.CartTax;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the CartTax entity validation.
 * This test class validates the constraints on the CartTax fields
 * using the javax. Validation API.
 */
public class CartTaxApplicationTests {

    /**
     * The Validator instance used to validate the CartTax object.
     */
    private Validator validator;

    /**
     * Sets up the Validator instance before each test execution.
     */
    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Test case to validate a valid CartTax object.
     * Ensures that no validation errors occur for correct data.
     */
    @Test
    public void testValidCartTax() {
        CartTax cartTax = getValidCartTax();
        Set<ConstraintViolation<CartTax>>
                violations = validator.validate(cartTax);

        // Assert that there are no violations for valid data
        assertTrue(violations.isEmpty());
    }

    /**
     * Test case to validate an invalid CartTax object with an empty Cart ID.
     * Ensures that the Cart ID constraint is properly validated.
     */
    @Test
    public void testInvalidCartId() {
        CartTax cartTax = getValidCartTax();
        cartTax.setCartId("");  // Invalid Cart ID (blank)
        Set<ConstraintViolation<CartTax>> violations =
                validator.validate(cartTax);

        // Expecting a single violation for cartId
        assertEquals(1, violations.size());
        assertTrue(violations.iterator().next().getMessage()
                .contains("Cart ID cannot be empty"));
    }

    /**
     * Test case to validate an invalid CartTax object with an empty
     * Cart Item ID.
     * Ensures that the Cart Item ID constraint is properly validated.
     */
    @Test
    public void testInvalidCartItemId() {
        CartTax cartTax = getValidCartTax();
        cartTax.setCartItemId("");  // Invalid Cart Item ID (blank)
        Set<ConstraintViolation<CartTax>> violations = validator
                .validate(cartTax);

        // Expecting a single violation for cartItemId
        assertEquals(1, violations.size());
        assertTrue(violations.iterator().next().getMessage()
                .contains("Cart Item ID cannot be empty"));
    }

    /**
     * Test case to validate an invalid CartTax object with
     * a name that is too short.
     * Ensures that the Name constraint (minimum length) is properly validated.
     */
    @Test
    public void testInvalidName() {
        CartTax cartTax = getValidCartTax();
        cartTax.setName("AB");  // Invalid name (less than 3 characters)
        Set<ConstraintViolation<CartTax>> violations = validator
                .validate(cartTax);

        // Expecting a single violation for name
        assertEquals(1, violations.size());
        assertTrue(violations.iterator().next().getMessage()
                .contains("Name must be between 3 and 100 characters"));
    }

    /**
     * Test case to validate an invalid CartTax object with a tax rate of 0.
     * Ensures that the Tax Rate constraint (must be greater than 0)
     * is properly validated.
     */
    @Test
    public void testInvalidTaxRate() {
        CartTax cartTax = getValidCartTax();
        cartTax.setTaxRate(0);  // Invalid tax rate (should be greater than 0)
        Set<ConstraintViolation<CartTax>> violations = validator
                .validate(cartTax);

        // Expecting a single violation for taxRate
        assertEquals(1, violations.size());
        assertTrue(violations.iterator().next().getMessage()
                .contains("Tax rate must be greater than 0"));
    }

    /**
     * Test case to validate an invalid CartTax object with an empty Tax Type.
     * Ensures that the Tax Type constraint (must contain at least one value)
     * is properly validated.
     */
    @Test
    public void testInvalidTaxType() {
        CartTax cartTax = getValidCartTax();
        cartTax.setTaxType(new String[]{});  // Invalid tax type (empty array)
        Set<ConstraintViolation<CartTax>> violations = validator
                .validate(cartTax);

        // Expecting a single violation for taxType
        assertEquals(1, violations.size());
        assertTrue(violations.iterator().next().getMessage()
                .contains("Tax type must contain at least one value"));
    }

    /**
     * Test case to validate an invalid CartTax object with
     * a future Tax Calculation Date.
     * Ensures that the Tax Calculation Date constraint
     * (must be in the past or present) is properly validated.
     */
    @Test
    public void testInvalidTaxCalculationDate() {
        CartTax cartTax = getValidCartTax();
        cartTax.setTaxCalculationDate(LocalDateTime.now().plusDays(1));
        // Future date (invalid)
        Set<ConstraintViolation<CartTax>> violations = validator
                .validate(cartTax);

        // Expecting a single violation for taxCalculationDate
        assertEquals(1, violations.size());
        assertTrue(violations.iterator().next().getMessage().contains
                ("Tax calculation date must be in the past or present"));
    }

    /**
     * Helper method to create a valid CartTax object.
     *
     * @return a valid CartTax object with all fields set to valid values.
     */
    private CartTax getValidCartTax() {
        CartTax cartTax = new CartTax();
        cartTax.setCartId("cart123");
        cartTax.setCartItemId("item123");
        cartTax.setName("Sales Tax");
        cartTax.setDescription("Sales tax applied on the item");
        cartTax.setTaxRate(7.5);
        cartTax.setTaxType(new String[]{"STATE_TAX"});
        cartTax.setCreatedBy("adminUser");
        cartTax.setTaxCalculationDate(LocalDateTime.now());
        return cartTax;
    }
}
