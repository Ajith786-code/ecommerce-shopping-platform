package com.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;

import com.ecommerce.model.CartItem;

public interface CartService {
    List<CartItem> getCartItems(Long userId);
    void addToCart(Long userId, Long productId, int quantity);
    void updateQuantity(Long cartItemId, int quantity);
    void removeItem(Long cartItemId);
    void clearCart(Long userId);
    BigDecimal calculateTotal(Long userId);
}
