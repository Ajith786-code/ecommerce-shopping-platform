package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

    @Mock
    private CartItemRepository cartItemRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    private CartItem item1;
    private CartItem item2;

    @BeforeEach
    void setUp() {
        Product p1 = new Product();
        p1.setId(1L);
        p1.setPrice(new BigDecimal("100.00"));

        Product p2 = new Product();
        p2.setId(2L);
        p2.setPrice(new BigDecimal("50.00"));

        item1 = new CartItem();
        item1.setProduct(p1);
        item1.setQuantity(2); // 200.00

        item2 = new CartItem();
        item2.setProduct(p2);
        item2.setQuantity(3); // 150.00
    }

    @Test
    void calculateTotal_sumsAllCartItemsCorrectly() {
        when(cartItemRepository.findByUserId(1L)).thenReturn(List.of(item1, item2));

        BigDecimal total = cartService.calculateTotal(1L);

        assertEquals(new BigDecimal("350.00"), total);
    }
}
