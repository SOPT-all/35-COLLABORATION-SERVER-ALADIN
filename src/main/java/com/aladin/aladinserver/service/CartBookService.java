package com.aladin.aladinserver.service;

import com.aladin.aladinserver.entity.CartBook;
import com.aladin.aladinserver.repository.CartBookRepository;
import com.aladin.aladinserver.service.response.CartResponse;
import com.aladin.aladinserver.service.response.CartsResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CartBookService {
    private final CartBookRepository cartBookRepository;

    public CartBookService(CartBookRepository cartBookRepository) {
        this.cartBookRepository = cartBookRepository;
    }

    public CartsResponse findCartById(long id) {
        List<CartResponse> list = cartBookRepository.findByCartBookWithCartAndBookByUserId(id)
                .stream().map(CartResponse::from).toList();
        return new CartsResponse(list);

    }
}
