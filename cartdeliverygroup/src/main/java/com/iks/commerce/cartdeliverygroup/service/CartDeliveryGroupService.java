package com.iks.commerce.cartdeliverygroup.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iks.commerce.cartdeliverygroup.model.CartDeliveryGroup;
import com.iks.commerce.cartdeliverygroup.repository.CartDeliveryGroupRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_CART_FOUND;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_CART_NOT_FOUND;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_DELETE_NOT_FOUND;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_DELETE_REQUEST;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_DELETE_SUCCESS;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_GET_REQUEST;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_INSERT_REQUEST;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_INSERT_SUCCESS;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_UPDATE_REQUEST;
import static com.iks.commerce.cartdeliverygroup.constant.CartDeliveryGroupConstants.LOG_UPDATE_SUCCESS;

/**
 * The type Cart delivery group service.
 */
@SuppressWarnings("PMD.TooManyStaticImports")
@Service
public class CartDeliveryGroupService {
    /**
     * Repository interface for accessing cart data in the database.
     * This is used to perform CRUD operations on the Cart entity.
     */
    @Autowired
    private CartDeliveryGroupRepo cartDeliveryGroupRepo;

    /**
     * logger for logging information.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(CartDeliveryGroupService
            .class);

    /**
     * Insert cart delivery group.
     *
     * @param cartDeliveryGroup the cart delivery group
     * @return the cart delivery group
     * @throws Exception the exception
     */
    public CartDeliveryGroup insert(final CartDeliveryGroup cartDeliveryGroup) {

            LOG.info(LOG_INSERT_REQUEST);
            cartDeliveryGroup.setCreatedOn(new Date());
            CartDeliveryGroup cartDelGrp = cartDeliveryGroupRepo
                    .save(cartDeliveryGroup);
            LOG.info(LOG_INSERT_SUCCESS);
            return cartDelGrp;

    }


    /**
     * Gets delivery group.
     *
     * @param id the id
     * @return the delivery group
     */
    public Optional<CartDeliveryGroup> getDeliveryGroup(final String id) {

        LOG.info(LOG_GET_REQUEST);


            Optional<CartDeliveryGroup> optionalCartDeliveryGroup =
                    cartDeliveryGroupRepo.findById(id);

            optionalCartDeliveryGroup.ifPresentOrElse(
                    value -> LOG.info(LOG_CART_FOUND),
                    () -> LOG.warn(LOG_CART_NOT_FOUND)
            );

            return optionalCartDeliveryGroup;

    }


    /**
     * Update delivery group cart delivery group.
     *
     * @param id           the id
     * @param updatedGroup the updated group
     * @return the cart delivery group
     */
    public CartDeliveryGroup updateDeliveryGroup(final String id,
                                                 final CartDeliveryGroup
                                                         updatedGroup) {

        LOG.info(LOG_UPDATE_REQUEST);

            Optional<CartDeliveryGroup> optionalCartDeliveryGroup =
                    cartDeliveryGroupRepo.findById(id);

            if (optionalCartDeliveryGroup.isPresent()) {
                CartDeliveryGroup existingCartDeliveryGroup =
                        optionalCartDeliveryGroup.get();

                existingCartDeliveryGroup.setDeliverToAddress(
                        updatedGroup.getDeliverToAddress());
                existingCartDeliveryGroup.setDesiredDeliveryDate(
                        updatedGroup.getDesiredDeliveryDate());
                existingCartDeliveryGroup.setGrandTotalAmount(
                        updatedGroup.getGrandTotalAmount());
                existingCartDeliveryGroup.setShippingInstructions(
                        updatedGroup.getShippingInstructions());

                CartDeliveryGroup savedCartDeliveryGroup =
                        cartDeliveryGroupRepo.save(existingCartDeliveryGroup);

                LOG.info(LOG_UPDATE_SUCCESS);

                return savedCartDeliveryGroup;
            } else {
                LOG.warn(LOG_CART_NOT_FOUND);
                throw new IllegalArgumentException(LOG_CART_NOT_FOUND);
            }

    }

    /**
     * Search by cart id list.
     *
     * @param cartId the cart id
     * @return the list
     */
    public List<CartDeliveryGroup> searchByCartId(final String cartId) {
        return cartDeliveryGroupRepo.findByCartId(cartId);
    }

    /**
     * Search by customer name list.
     *
     * @param customerName the customer name
     * @return the list
     */
    public List<CartDeliveryGroup> searchByCustomerName(
            final String customerName) {
        return cartDeliveryGroupRepo.findByCustomerNameIgnoreCase(customerName);
    }

    /**
     * Search by delivery method id list.
     *
     * @param deliveryMethodId the delivery method id
     * @return the list
     */
    public List<CartDeliveryGroup> searchByDeliveryMethodId(
            final String deliveryMethodId) {
        return cartDeliveryGroupRepo.findByDeliveryMethodId(deliveryMethodId);
    }

    /**
     * Search by ship to phone number list.
     *
     * @param shipToPhoneNumber the ship to phone number
     * @return the list
     */
    public List<CartDeliveryGroup> searchByShipToPhoneNumber(
            final String shipToPhoneNumber) {
        return cartDeliveryGroupRepo.findByShipToPhoneNumber(shipToPhoneNumber);
    }


    /**
     * Deletes the delivery group with the given id.
     * <p>
     * If the delivery group exists, it is deleted and the method returns true.
     * If the delivery group does not exist, the method returns false.
     *
     * @param id the id of the delivery group to be deleted
     * @return true if the deletion was successful,
     * false if the delivery group was not found
     */
    public boolean deleteDeliveryGroup(final String id) {
        LOG.info(LOG_DELETE_REQUEST);
        Optional<CartDeliveryGroup> deliveryGroup = cartDeliveryGroupRepo
                .findById(id);

        if (deliveryGroup.isPresent()) {
            cartDeliveryGroupRepo.deleteById(id);
            LOG.info(LOG_DELETE_SUCCESS);
            return true;
        } else {
            LOG.warn(LOG_DELETE_NOT_FOUND);
            return false;
        }
    }

}
