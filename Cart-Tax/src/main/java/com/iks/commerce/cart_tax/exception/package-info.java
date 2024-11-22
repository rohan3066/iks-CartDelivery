/**
 * This package contains custom exception classes used across the return
 * order module.
 *
 * <p>
 * These exceptions are designed to handle various error scenarios that
 * may occur
 * during the execution of business logic, validation, or while interacting
 * with external systems.
 * Each exception is associated with specific error conditions, and
 * the controller layer uses
 * these exceptions to generate meaningful HTTP responses.
 * </p>
 *
 * <p>
 * Example exceptions include:
 * <ul>
 *   <li>{@link
 *   com.iks.commerce.cart_tax.exception.CustomMethodArgumentNotValidException}
 *   - Thrown when validation errors occur.</li>
 *   <li>{@link com.iks.commerce.cart_tax.exception.ResourceNotFound} -
 *   Thrown when a requested resource, such as a return order, is not found.
 *   </li>
 * </ul>
 * </p>
 *
 * <p>
 * These exceptions help to centralize and streamline error handling within
 * the application.
 * By using custom exceptions, the application can maintain clear separation
 * between
 * business logic and error management, while ensuring consistent responses
 * to clients.
 * </p>
 *
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Throw {@link com.iks.commerce.cart_tax.exception.ResourceNotFound}
 *   when an entity like a return order is not found in the system.</li>
 *   <li>Throw {@link
 *   com.iks.commerce.cart_tax.exception.CustomMethodArgumentNotValidException}
 *   when a validation failure occurs for a request object.</li>
 * </ul>
 */


package com.iks.commerce.cart_tax.exception;
