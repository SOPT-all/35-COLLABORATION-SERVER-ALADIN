package com.aladin.aladinserver.service.response;

import com.aladin.aladinserver.entity.CartBook;

public record CartResponse(long id,
                           String name,
                           int discountRate,
                           int price,
                           int discountedPrice,
                           String imageUrl) {
    public static CartResponse from(CartBook cartBook) {
        return new CartResponse(
                cartBook.getId(),
                cartBook.getBook().getTitle(),
                cartBook.getBook().getDiscount(),
                cartBook.getBook().getPrice(),
                (int)((100-cartBook.getBook().getDiscount())*cartBook.getBook().getPrice()*0.01),
                cartBook.getBook().getImageUrl()
        );
    }
}
