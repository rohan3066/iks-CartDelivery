package com.iks.commerce.cart_tax.controller;

import com.iks.commerce.cart_tax.exception.
        CustomMethodArgumentNotValidException;
import com.iks.commerce.cart_tax.exception.ResourceNotFound;
import com.iks.commerce.cart_tax.model.CartTax;
import com.iks.commerce.cart_tax.service.CartTaxService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * The type Cart tax controller.
 */
@RestController
@RequestMapping("/api/cart-tax")
public class CartTaxController {

    /**
     * The CartTaxService instance.
     */
    private final CartTaxService cartTaxService;

    /**
     * Instantiates a new Cart tax controller.
     *
     * @param service the cart tax service
     */
    public CartTaxController(final CartTaxService service) {
        this.cartTaxService = service;
    }

    /**
     * Add cart tax response entity.
     *
     * @param cartTax       the cart tax
     * @param bindingResult the binding result
     * @return the response entity
     * @throws CustomMethodArgumentNotValidException
     * the custom method argument not valid exception
     */
    @PostMapping
    public ResponseEntity<?> addCartTax(
            @Valid @RequestBody final CartTax cartTax,
            final BindingResult bindingResult)
            throws CustomMethodArgumentNotValidException {
        try {
            if (bindingResult.hasErrors()) {
                throw new CustomMethodArgumentNotValidException(null,
                        bindingResult);
            }
            return new ResponseEntity<>(cartTaxService.addCartTax(cartTax),
                    HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("ERROR: " + e.getMessage());
        }
    }

    /**
     * Gets cart tax by id.
     *
     * @param id the id
     * @return the cart tax by id
     * @throws ResourceNotFound the resource not found exception
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCartTaxById(@PathVariable final String id)
            throws ResourceNotFound {
        try {
            Optional<CartTax> cartTax = cartTaxService.getCartTaxById(id);
            if (cartTax.isEmpty()) {
                throw new ResourceNotFound("Cart tax with ID "
                        + id + " not found");
            }
            return new ResponseEntity<>(cartTax, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("ERROR: " + e.getMessage());
        }
    }

    /**
     * Update cart tax response entity.
     *
     * @param id             the id
     * @param updatedCartTax the updated cart tax
     * @param bindingResult  the binding result
     * @return the response entity
     * @throws CustomMethodArgumentNotValidException
     * the custom method argument not valid exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCartTax(
            @PathVariable final String id,
            @Valid @RequestBody final CartTax updatedCartTax,
            final BindingResult bindingResult)
            throws CustomMethodArgumentNotValidException {
        try {
            if (bindingResult.hasErrors()) {
                throw new CustomMethodArgumentNotValidException(null,
                        bindingResult);
            }
            CartTax updatedTax = cartTaxService
                    .updateCartTax(id, updatedCartTax);
            return ResponseEntity.ok(updatedTax);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("ERROR: " + e.getMessage());
        }
    }

    /**
     * Delete cart tax response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartTax(@PathVariable final String id) {
        try {
            cartTaxService.deleteCartTax(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: " + e.getMessage());
        }
    }
}
