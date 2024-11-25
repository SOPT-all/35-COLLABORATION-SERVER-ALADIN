package com.aladin.aladinserver.service;

import com.aladin.aladinserver.repository.CartBookRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartBookRepository cartBookRepository;

    public CartService(CartBookRepository cartBookRepository) {
        this.cartBookRepository = cartBookRepository;
    }

    public void findCartById(long id) {

    }
}
