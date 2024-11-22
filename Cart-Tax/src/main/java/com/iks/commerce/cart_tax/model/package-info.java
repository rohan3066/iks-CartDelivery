/**
 * This package contains the data models used in the return order module.
 *
 * <p>
 * The models in this package represent the entities involved in
 * the return order process,
 * such as {@link com.iks.commerce.cart_tax.model.CartTax}
 * and other related entities.
 * These models define the structure
 * of the data that is persisted in the database and transferred between
 * different layers of the application.
 * </p>
 *
 * <p>
 * Each model class typically includes fields that correspond to
 * the attributes of a return order,
 * along with appropriate validation annotations to enforce business rules.
 * </p>
 *
 * <p><strong>Example Models:</strong></p>
 * <ul>
 *   <li>{@link com.iks.commerce.cart_tax.model.CartTax} -
 *   Represents the return order entity with fields like order ID,
 *       billing address, total amount, created date, and more.</li>
 * </ul>
 *
 * <p>
 * The models in this package play a critical role in defining the
 * structure of the domain data,
 * ensuring that it is validated and correctly mapped to the database schema.
 * </p>
 *
 * <p><strong>Validation:</strong></p>
 * <ul>
 *   <li>Each model uses annotations such as
 *   {@link jakarta.validation.constraints.NotBlank},
 *       {@link jakarta.validation.constraints.Size}, and
 *       {@link jakarta.validation.constraints.PastOrPresent}
 *       to validate data before it is persisted.</li>
 * </ul>
 *
 * <p>
 * These models are integral to the application’s data
 * integrity and play a key role in enforcing business rules.
 * </p>
 */
package com.iks.commerce.cart_tax.model;
