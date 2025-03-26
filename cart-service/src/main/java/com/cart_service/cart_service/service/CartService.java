package com.cart_service.cart_service.service;


import com.cart_service.cart_service.client.ProductClient;
import com.cart_service.cart_service.client.UserClient;
import com.cart_service.cart_service.dto.CartItemRequest;
import com.cart_service.cart_service.model.Cart;
import com.cart_service.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;

    public Cart addToCart(String userId, CartItemRequest request) {
        userClient.getUserById(userId); // Validate user
        productClient.getProductById(request.getProductId()); // Validate product

        Cart cart = cartRepository.findByUserId(userId).orElse(new Cart());
        cart.setUserId(userId);

        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }

        Cart.CartItem item = new Cart.CartItem();
        item.setProductId(request.getProductId());
        item.setQuantity(request.getQuantity());

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId).orElse(null);
    }
}


