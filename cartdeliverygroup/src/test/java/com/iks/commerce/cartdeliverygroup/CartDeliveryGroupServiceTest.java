package com.iks.commerce.cartdeliverygroup;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import com.iks.commerce.cartdeliverygroup.model.CartDeliveryGroup;
import com.iks.commerce.cartdeliverygroup.repository.CartDeliveryGroupRepo;

import com.iks.commerce.cartdeliverygroup.service.CartDeliveryGroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CartDeliveryGroupServiceTest {

    @Mock
    private CartDeliveryGroupRepo cartDeliveryGroupRepo;

    @InjectMocks
    private CartDeliveryGroupService cartDeliveryGroupService;

    private CartDeliveryGroup mockCartDeliveryGroup;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a mock CartDeliveryGroup object
        mockCartDeliveryGroup = new CartDeliveryGroup();
        mockCartDeliveryGroup.setId(UUID.randomUUID().toString());
        mockCartDeliveryGroup.setCartId(UUID.randomUUID().toString());
        mockCartDeliveryGroup.setDeliveryMethodId(UUID.randomUUID().toString());
        mockCartDeliveryGroup.setCreatedDate(new Date());
        mockCartDeliveryGroup.setGrandTotalAmount(100.0);
        mockCartDeliveryGroup.setTotalAmount(90.0);
    }

    @Test
    void testInsertDeliveryGroupSuccess() throws Exception {
        // Arrange
        when(cartDeliveryGroupRepo.save(any(CartDeliveryGroup.class)))
                .thenReturn(mockCartDeliveryGroup);

        // Act
        CartDeliveryGroup insertedGroup = cartDeliveryGroupService
                .insert(mockCartDeliveryGroup);

        // Assert
        assertNotNull(insertedGroup);
        assertEquals(mockCartDeliveryGroup.getGrandTotalAmount(),
                insertedGroup.getGrandTotalAmount());
        verify(cartDeliveryGroupRepo, times(1))
                .save(any(CartDeliveryGroup.class));
    }

    @Test
    void testInsertDeliveryGroupFailure() {
        // Arrange
        when(cartDeliveryGroupRepo.save(any(CartDeliveryGroup.class)))
                .thenThrow(new RuntimeException("Error saving delivery group"));

        // Act and Assert
        assertThrows(Exception.class, () -> {
            cartDeliveryGroupService.insert(mockCartDeliveryGroup);
        });
        verify(cartDeliveryGroupRepo, times(1))
                .save(any(CartDeliveryGroup.class));
    }

    @Test
    void testGetDeliveryGroupSuccess() {
        // Arrange
        when(cartDeliveryGroupRepo.findById(anyString()))
                .thenReturn(Optional.of(mockCartDeliveryGroup));

        // Act
        Optional<CartDeliveryGroup> foundGroup = cartDeliveryGroupService
                .getDeliveryGroup(mockCartDeliveryGroup.getId());

        // Assert
        assertTrue(foundGroup.isPresent());
        assertEquals(mockCartDeliveryGroup.getId(), foundGroup.get().getId());
        verify(cartDeliveryGroupRepo, times(1)).findById(anyString());
    }

    @Test
    void testGetDeliveryGroupNotFound() {
        // Arrange
        when(cartDeliveryGroupRepo.findById(anyString()))
                .thenReturn(Optional.empty());

        // Act
        Optional<CartDeliveryGroup> foundGroup = cartDeliveryGroupService
                .getDeliveryGroup("nonExistentId");

        // Assert
        assertFalse(foundGroup.isPresent());
        verify(cartDeliveryGroupRepo, times(1)).findById(anyString());
    }

    @Test
    void testUpdateDeliveryGroupSuccess() {
        // Arrange
        CartDeliveryGroup updatedGroup = new CartDeliveryGroup();
        updatedGroup.setGrandTotalAmount(150.0);
        updatedGroup.setDeliverToAddress("New Address");

        when(cartDeliveryGroupRepo.findById(anyString()))
                .thenReturn(Optional.of(mockCartDeliveryGroup));
        when(cartDeliveryGroupRepo.save(any(CartDeliveryGroup.class)))
                .thenReturn(mockCartDeliveryGroup);

        // Act
        CartDeliveryGroup result = cartDeliveryGroupService
                .updateDeliveryGroup(mockCartDeliveryGroup.getId(), updatedGroup);

        // Assert
        assertNotNull(result);
        assertEquals(updatedGroup.getGrandTotalAmount(),
                result.getGrandTotalAmount());
        verify(cartDeliveryGroupRepo, times(1)).findById(anyString());
        verify(cartDeliveryGroupRepo, times(1)).save(any(CartDeliveryGroup.class));
    }

    @Test
    void testUpdateDeliveryGroupNotFound() {
        // Arrange
        CartDeliveryGroup updatedGroup = new CartDeliveryGroup();
        updatedGroup.setGrandTotalAmount(150.0);

        when(cartDeliveryGroupRepo.findById(anyString()))
                .thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cartDeliveryGroupService.updateDeliveryGroup("nonExistentId",
                    updatedGroup);
        });
        verify(cartDeliveryGroupRepo, times(1)).findById(anyString());
        verify(cartDeliveryGroupRepo, never()).save(any(CartDeliveryGroup.class));
    }

    @Test
    void testDeleteDeliveryGroupSuccess() {
        // Arrange
        when(cartDeliveryGroupRepo.findById(anyString()))
                .thenReturn(Optional.of(mockCartDeliveryGroup));

        // Act
        boolean isDeleted = cartDeliveryGroupService
                .deleteDeliveryGroup(mockCartDeliveryGroup.getId());

        // Assert
        assertTrue(isDeleted);
        verify(cartDeliveryGroupRepo, times(1)).findById(anyString());
        verify(cartDeliveryGroupRepo, times(1)).deleteById(anyString());
    }

    @Test
    void testDeleteDeliveryGroupNotFound() {
        // Arrange
        when(cartDeliveryGroupRepo.findById(anyString()))
                .thenReturn(Optional.empty());

        // Act
        boolean isDeleted = cartDeliveryGroupService
                .deleteDeliveryGroup("nonExistentId");

        // Assert
        assertFalse(isDeleted);
        verify(cartDeliveryGroupRepo, times(1)).findById(anyString());
        verify(cartDeliveryGroupRepo, never()).deleteById(anyString());
    }
}

