package com.ecommerce.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ecommerce.model.User;

public interface UserService extends UserDetailsService {
    User register(User user);
    User findByEmail(String email);
}
