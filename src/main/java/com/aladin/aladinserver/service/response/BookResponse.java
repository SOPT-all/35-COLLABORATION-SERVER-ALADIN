package com.aladin.aladinserver.service.response;

import com.aladin.aladinserver.entity.Book;

public record BookResponse(long id, String name, String imageUrl) {
    public static BookResponse from(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getImageUrl());
    }
}
