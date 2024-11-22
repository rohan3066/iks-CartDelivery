package com.iks.commerce.cartdeliverygroup.controller;


import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iks.commerce.cartdeliverygroup.model.CartDeliveryGroup;
import com.iks.commerce.cartdeliverygroup.service.CartDeliveryGroupService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.
        ERROR_AMOUNT_NEGATIVE;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.
        ERROR_DELETE;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.
        ERROR_UPDATE_NOT_FOUND;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.
        ZERO;


/**
 * The type Cart delivery group controller.
 */
@RestController
@RequestMapping("/cartsdeliverygroup")
public class CartDeliveryGroupController {

    /**
     * insance of CartDeliveryGroupService.
     */
    @Autowired
    private CartDeliveryGroupService cartDeliveryGroupService;

    /**
     * logger for logging information.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(CartDeliveryGroupService
                    .class);

    /**
     * Insert response entity.
     *
     * @param cartDeliveryGroup the cart delivery group
     * @return the response entity
     */
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@Valid @RequestBody final
                                        CartDeliveryGroup cartDeliveryGroup) {

            validate(cartDeliveryGroup);
            CartDeliveryGroup cartDelGrp =
                    cartDeliveryGroupService
                            .insert(cartDeliveryGroup);
                    return new ResponseEntity<>(cartDelGrp,
                            HttpStatus.CREATED);
    }

    /**
     * Get delivery group response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDeliveryGroup(@PathVariable final String id) {

            Optional<CartDeliveryGroup> optionalCartDeliveryGroup =
                    cartDeliveryGroupService.getDeliveryGroup(id);

            return optionalCartDeliveryGroup.map(
                    value ->
                            new ResponseEntity(optionalCartDeliveryGroup.get(),
                                    HttpStatus.FOUND)).orElseGet(
                    () -> new ResponseEntity(
                            ERROR_UPDATE_NOT_FOUND,
                            HttpStatus.NOT_FOUND)
            );
    }


    /**
     * Update delivery group response entity.
     *
     * @param id           the id
     * @param updatedGroup the updated group
     * @return the response entity
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDeliveryGroup(
            @PathVariable final String id,
            @RequestBody final CartDeliveryGroup updatedGroup) {

            CartDeliveryGroup updatedCartDeliveryGroup =
                    cartDeliveryGroupService.updateDeliveryGroup(
                            id, updatedGroup);
            return new ResponseEntity<>(updatedCartDeliveryGroup,
                    HttpStatus.OK);
    }


    /**
     * Deletes the delivery group with the given id from the cart.
     * <p>
     * If the deletion is successful, returns 204 No Content.
     * If the delivery group with the given id does not exist,
     * returns 404 Not Found.
     * All deletion attempts are logged for auditing purposes.
     *
     * @param id the id of the delivery group to be deleted
     * @return the response entity with appropriate HTTP status code
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDeliveryGroup(@PathVariable final
                                                     String id) {

            boolean isDeleted = cartDeliveryGroupService
                    .deleteDeliveryGroup(id);

            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(ERROR_DELETE,
                        HttpStatus.NOT_FOUND);
            }
    }

    /**
     * Search by cart id response entity.
     *
     * @param cartId the cart id
     * @return the response entity
     */
    @GetMapping("/searchBycartId/{cartId}")
    public ResponseEntity<List<CartDeliveryGroup>> searchByCartId(
            @PathVariable final String cartId) {
        List<CartDeliveryGroup> groups = cartDeliveryGroupService
                .searchByCartId(cartId);
        return groups.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(groups, HttpStatus.OK);
    }

    /**
     * Search by customer name response entity.
     *
     * @param customerName the customer name
     * @return the response entity
     */
    @GetMapping("/searchBycustomerName/{customerName}")
    public ResponseEntity<List<CartDeliveryGroup>> searchByCustomerName(
            @PathVariable final String customerName) {
        List<CartDeliveryGroup> groups = cartDeliveryGroupService.
                searchByCustomerName(customerName);
        return groups.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(groups, HttpStatus.OK);
    }

    /**
     * Search by delivery method id response entity.
     *
     * @param deliveryMethodId the delivery method id
     * @return the response entity
     */
    @GetMapping("/searchBydeliveryMethodId/{deliveryMethodId}")
    public ResponseEntity<List<CartDeliveryGroup>> searchByDeliveryMethodId(
            @PathVariable final String deliveryMethodId) {
        List<CartDeliveryGroup> results = cartDeliveryGroupService.
                searchByDeliveryMethodId(deliveryMethodId);
        return ResponseEntity.ok(results);
    }

    /**
     * Search by ship to phone number response entity.
     *
     * @param shipToPhoneNumber the ship to phone number
     * @return the response entity
     */
    @GetMapping("/searchByshipToPhone/{shipToPhoneNumber}")
    public ResponseEntity<List<CartDeliveryGroup>> searchByShipToPhoneNumber(
            @PathVariable final String shipToPhoneNumber) {
        List<CartDeliveryGroup> results = cartDeliveryGroupService.
                searchByShipToPhoneNumber(shipToPhoneNumber);
        return ResponseEntity.ok(results);
    }

    /**
     * Validates the given {@link CartDeliveryGroup} object.
     * <p>
     * This method checks if the grand total amount and
     * total amount are negative
     * values. If either of these values is negative,
     * an {@link IllegalArgumentException}
     * is thrown with a relevant error message.
     *
     * @param cartDeliveryGroup the {@link CartDeliveryGroup} object
     *                          to be validated
     * @throws IllegalArgumentException if grand total amount or
     * total amount is negative
     */
    private void validate(final CartDeliveryGroup cartDeliveryGroup) {
        if (isNegative(cartDeliveryGroup.getGrandTotalAmount(),
                cartDeliveryGroup.getTotalAmount())) {
            throw new IllegalArgumentException(ERROR_AMOUNT_NEGATIVE);
        }
    }

    /**
     * Checks if either the grand total amount or total amount is negative.
     *
     * @param grandTotalAmount the grand total amount to be validated
     * @param totalAmount      the total amount to be validated
     * @return {@code true} if either grand total
     * amount or total amount is negative;
     *         {@code false} otherwise
     */
    private boolean isNegative(final double grandTotalAmount,
                               final double totalAmount) {
        return grandTotalAmount < ZERO || totalAmount < ZERO;
    }





}
