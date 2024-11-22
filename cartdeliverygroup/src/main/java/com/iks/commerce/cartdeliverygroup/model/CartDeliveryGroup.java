package com.iks.commerce.cartdeliverygroup.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * The type Cart delivery group.
 */
@Document(collection = "cartdeliverygroup")
public class CartDeliveryGroup {
    /**
     * The unique identifier for the delivery group.
     */
    @Id
    private String id;

    /**
     * The unique identifier for the cart associated with this delivery group.
     */
    @NotEmpty(message = "Cart Id is required")
    private String cartId;

    /**
     * The date when the delivery group was created.
     */
    private Date createdOn;

    /**
     * The first name of the person receiving the delivery.
     * This field is required and cannot be empty.
     */
    @NotEmpty(message = "First name of the recipient is required")
    private String deliverToFirstName;

    /**
     * The last name of the person receiving the delivery.
     * This field is required and cannot be empty.
     */
    @NotEmpty(message = "Last Name of the recipient is required")
    private String deliveryToLastName;

    /**
     * The full name of the person receiving the delivery.
     * This field is required and cannot be empty.
     */
    @NotEmpty(message = "Full name of the recipient is required")
    private String deliverToName;

    /**
     * The address where the delivery will be made.
     * This field is required and cannot be empty.
     */
    @NotEmpty(message = "Address for delivery is required")
    private String deliverToAddress;

    /**
     * The desired date for the delivery. This field can be null
     * but should be provided when available to schedule deliveries.
     */
    @NotNull(message = "Delivery Date is required")
    private Date desiredDeliveryDate;

    /**
     * The total amount for the delivery group, including taxes and fees.
     * This field is required and cannot be null.
     */
    @NotNull(message = "Grand Total Amount is required")
    private Double grandTotalAmount;

    /**
     * The name of the customer associated with this delivery group.
     * This field is required and cannot be empty.
     */
    @NotEmpty(message = "Customer name is required")
    private String customerName;

    /**
     * The unique identifier for the delivery method selected by the customer.
     */
    @NotEmpty(message = "Deivery method is required")
    private String deliveryMethodId;

    /**
     * A flag indicating whether this delivery group is the default delivery
     * choice for the cart. True if it is the default, false otherwise.
     */
    private boolean isDefault;

    /**
     * The phone number of the recipient for the delivery.
     * This field is required and cannot be empty.
     */
    @NotNull(message = "Phone number of recipient is required")
    private String shipToPhoneNumber;

    /**
     * Any special instructions related to the delivery, such as where to leave
     * the package or handling instructions. This field is required.
     */
    @NotEmpty(message = "Shipping instructions are required")
    private String shippingInstructions;

    /**
     * The subtotal amount for the delivery group before any additional charges
     * such as taxes or fees.
     */
    private Double totalAmount;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param idd the id
     */
    public void setId(final String idd) {
        this.id = idd;
    }

    /**
     * Gets cart id.
     *
     * @return the cart id
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * Sets cart id.
     *
     * @param cartid the cart id
     */
    public void setCartId(final String cartid) {
        this.cartId = cartid;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets created date.
     *
     * @param createddate the created date
     */
    public void setCreatedOn(final Date createddate) {
        this.createdOn = createddate;
    }

    /**
     * Gets deliver to first name.
     *
     * @return the deliver to first name
     */
    public String getDeliverToFirstName() {
        return deliverToFirstName;
    }

    /**
     * Sets deliver to first name.
     *
     * @param deliverFirstName the deliver to first name
     */
    public void setDeliverToFirstName(final String deliverFirstName) {
        this.deliverToFirstName = deliverFirstName;
    }

    /**
     * Gets delivery to last name.
     *
     * @return the delivery to last name
     */
    public  String getDeliveryToLastName() {
        return deliveryToLastName;
    }

    /**
     * Sets delivery to last name.
     *
     * @param deliveryLastName the delivery to last name
     */
    public void setDeliveryToLastName(final String deliveryLastName) {
        this.deliveryToLastName = deliveryLastName;
    }

    /**
     * Gets deliver to name.
     *
     * @return the deliver to name
     */
    public String getDeliverToName() {
        return deliverToName;
    }

    /**
     * Sets deliver to name.
     *
     * @param deliverName the deliver to name
     */
    public void setDeliverToName(final String deliverName) {
        this.deliverToName = deliverName;
    }

    /**
     * Gets deliver to address.
     *
     * @return the deliver to address
     */
    public String getDeliverToAddress() {
        return deliverToAddress;
    }

    /**
     * Sets deliver to address.
     *
     * @param deliverAddress the deliver to address
     */
    public void setDeliverToAddress(final String deliverAddress) {
        this.deliverToAddress = deliverAddress;
    }

    /**
     * Gets desired delivery date.
     *
     * @return the desired delivery date
     */
    public Date getDesiredDeliveryDate() {
        return desiredDeliveryDate;
    }

    /**
     * Sets desired delivery date.
     *
     * @param desiredeliveryDate the desired delivery date
     */
    public void setDesiredDeliveryDate(final Date desiredeliveryDate) {
        this.desiredDeliveryDate = desiredeliveryDate;
    }

    /**
     * Gets customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets customer name.
     *
     * @param custName the customer name
     */
    public void setCustomerName(final String custName) {
        this.customerName = custName;
    }


    /**
     * Gets grand total amount.
     *
     * @return the grand total amount
     */
    public double getGrandTotalAmount() {
        return grandTotalAmount;
    }

    /**
     * Sets grand total amount.
     *
     * @param grandTtlAmount the grand total amount
     */
    public void setGrandTotalAmount(final double grandTtlAmount) {
        this.grandTotalAmount = grandTtlAmount;
    }

    /**
     * Gets delivery method id.
     *
     * @return the delivery method id
     */
    public String getDeliveryMethodId() {
        return deliveryMethodId;
    }

    /**
     * Sets delivery method id.
     *
     * @param deliveryMtdId the delivery method id
     */
    public void setDeliveryMethodId(final String deliveryMtdId) {
        this.deliveryMethodId = deliveryMtdId;
    }

    /**
     * Is default boolean.
     *
     * @return the boolean
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Sets default.
     *
     * @param adefault the a default
     */
    public void setDefault(final boolean adefault) {
        isDefault = adefault;
    }

    /**
     * Gets ship to phone number.
     *
     * @return the ship to phone number
     */
    public String getShipToPhoneNumber() {
        return shipToPhoneNumber;
    }

    /**
     * Sets ship to phone number.
     *
     * @param shipPhoneNumber the ship to phone number
     */
    public void setShipToPhoneNumber(final String shipPhoneNumber) {

    }

    /**
     * Gets shipping instructions.
     *
     * @return the shipping instructions
     */
    public String getShippingInstructions() {
        return shippingInstructions;
    }

    /**
     * Sets shipping instructions.
     *
     * @param shipnstructions the shipping instructions
     */
    public void setShippingInstructions(final String shipnstructions) {
        this.shippingInstructions = shipnstructions;
    }

    /**
     * Gets total amount.
     *
     * @return the total amount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets total amount.
     *
     * @param totalAmt the total amount
     */
    public void setTotalAmount(final double totalAmt) {
        this.totalAmount = totalAmt;
    }

    public void setCreatedDate(Date date) {
    }
}
