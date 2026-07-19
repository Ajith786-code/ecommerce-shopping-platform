package com.ecommerce.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.UserService;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;
    private final UserService userService;

    public OrderController(OrderService orderService, CartService cartService, UserService userService) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
    }

    private User currentUser(Authentication authentication) {
        return userService.findByEmail(authentication.getName());
    }

    @GetMapping("/checkout")
    public String checkoutPage(Authentication authentication, Model model) {
        User user = currentUser(authentication);
        model.addAttribute("cartItems", cartService.getCartItems(user.getId()));
        model.addAttribute("total", cartService.calculateTotal(user.getId()));
        return "checkout";
    }

    @PostMapping("/checkout")
    public String placeOrder(@RequestParam String shippingAddress,
                              Authentication authentication,
                              Model model) {
        User user = currentUser(authentication);
        try {
            Order order = orderService.placeOrder(user.getId(), shippingAddress);
            return "redirect:/orders/" + order.getId();
        } catch (IllegalStateException ex) {
            model.addAttribute("error", ex.getMessage());
            return "checkout";
        }
    }

    @GetMapping("/orders")
    public String orderHistory(Authentication authentication, Model model) {
        User user = currentUser(authentication);
        model.addAttribute("orders", orderService.getOrdersForUser(user.getId()));
        return "orders";
    }

    @GetMapping("/orders/{id}")
    public String orderDetail(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "order-detail";
    }
}
