package com.iks.commerce.cartdeliverygroup.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iks.commerce.cartdeliverygroup.model.CartDeliveryGroup;
import org.springframework.stereotype.Repository;

/**
 * The interface Cart delivery group repo.
 */
@Repository
public interface CartDeliveryGroupRepo extends
        MongoRepository<CartDeliveryGroup, String> {

    /**
     * Find by cart id list.
     *
     * @param cartId the cart id
     * @return the list
     */
// Custom query method to find by cartId
    List<CartDeliveryGroup> findByCartId(String cartId);

    /**
     * Find by customer name ignore case list.
     *
     * @param customerName the customer name
     * @return the list
     */
    List<CartDeliveryGroup> findByCustomerNameIgnoreCase(String customerName);

    /**
     * Find by delivery method id list.
     *
     * @param deliveryMethodId the delivery method id
     * @return the list
     */
    List<CartDeliveryGroup> findByDeliveryMethodId(String deliveryMethodId);

    /**
     * Find by ship to phone number list.
     *
     * @param shipToPhoneNumber the ship to phone number
     * @return the list
     */
    List<CartDeliveryGroup> findByShipToPhoneNumber(String shipToPhoneNumber);
}
