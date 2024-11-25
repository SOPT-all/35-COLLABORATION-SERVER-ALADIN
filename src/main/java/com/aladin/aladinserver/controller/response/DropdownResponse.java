package com.aladin.aladinserver.controller.response;

import java.util.List;
import java.util.Map;

public class DropdownResponse {
    private final Map<String, List<String>> categories; //domesticBooks 등등
    private final List<String> boldCategories; //bold 카테고리

    public DropdownResponse(Map<String, List<String>> categories, List<String> boldCategories) {
        this.categories = categories;
        this.boldCategories = boldCategories;
    }

    public Map<String, List<String>> getCategories() {
        return categories;
    }

    public List<String> getBoldCategories() {
        return boldCategories;
    }
}
