package com.ecommerce.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;

@Controller
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    private User currentUser(Authentication authentication) {
        return userService.findByEmail(authentication.getName());
    }

    @GetMapping("/cart")
    public String viewCart(Authentication authentication, Model model) {
        User user = currentUser(authentication);
        model.addAttribute("cartItems", cartService.getCartItems(user.getId()));
        model.addAttribute("total", cartService.calculateTotal(user.getId()));
        return "cart";
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable Long productId,
                             @RequestParam(defaultValue = "1") int quantity,
                             Authentication authentication) {
        User user = currentUser(authentication);
        cartService.addToCart(user.getId(), productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update/{cartItemId}")
    public String updateQuantity(@PathVariable Long cartItemId,
                                  @RequestParam int quantity) {
        cartService.updateQuantity(cartItemId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{cartItemId}")
    public String removeItem(@PathVariable Long cartItemId) {
        cartService.removeItem(cartItemId);
        return "redirect:/cart";
    }
}
