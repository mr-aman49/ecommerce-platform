package com.cart_service.cart_service.controller;


import com.cart_service.cart_service.dto.CartItemRequest;
import com.cart_service.cart_service.model.Cart;
import com.cart_service.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add")
    public Cart addToCart(@PathVariable String userId, @RequestBody CartItemRequest request) {
        return cartService.addToCart(userId, request);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        return cartService.getCartByUserId(userId);
    }
}