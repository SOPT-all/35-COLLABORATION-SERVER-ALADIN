package com.aladin.aladinserver.controller.response;

import com.aladin.aladinserver.entity.Book;

public class BookResponse {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;

    public BookResponse(Long id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    //Book 엔티티 받아서 dto로 변환
    public static BookResponse fromEntity(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getImageUrl()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
