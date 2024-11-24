package com.aladin.aladinserver.controller.response;

public class MainviewResponse {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;

    public MainviewResponse(Long id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
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
