package com.iks.commerce.cart_tax.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Custom method argument not valid exception.
 */
public class CustomMethodArgumentNotValidException
        extends MethodArgumentNotValidException {

    /**
     * Instantiates a new Custom method argument not valid exception.
     *
     * @param parameter     the parameter
     * @param bindingResult the binding result
     */
    public CustomMethodArgumentNotValidException(
            final MethodParameter parameter,
            final BindingResult bindingResult) {
        super(parameter, bindingResult);
    }

    /**
     * Gets error details.
     *
     * @return the error details
     */
    public Map<String, String> getErrorDetails() {
        Map<String, String> errors = new HashMap<>();
        getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
