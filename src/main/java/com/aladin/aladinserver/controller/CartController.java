package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.SuccessCode;
import com.aladin.aladinserver.controller.response.AladinResponse;
import com.aladin.aladinserver.service.CartBookService;
import com.aladin.aladinserver.service.CartService;
import com.aladin.aladinserver.service.response.CartResponse;
import com.aladin.aladinserver.service.response.CartsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users/me/carts")
@RestController
public class CartController {

    private final CartBookService cartBookService;

    public CartController(CartBookService cartService) {
        this.cartBookService = cartService;
    }

    @GetMapping
    public AladinResponse<CartsResponse> findCart(@RequestHeader("User-Id")long id) {
        return AladinResponse.success(SuccessCode.OK, cartBookService.findCartById(id));

    }
}
