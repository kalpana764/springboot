package com.ss.org.cartService.service;

import com.ss.org.cartService.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void addProductInCart(){

    }
}
