package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderStatus;

public interface OrderService {
    Order placeOrder(Long userId, String shippingAddress);
    List<Order> getOrdersForUser(Long userId);
    List<Order> getAllOrders();
    Order findById(Long id);
    void updateStatus(Long orderId, OrderStatus status);
}
