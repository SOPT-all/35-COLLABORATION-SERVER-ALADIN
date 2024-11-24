package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.SuccessCode;
import com.aladin.aladinserver.controller.response.AladinResponse;
import com.aladin.aladinserver.service.DropdownService;
import com.aladin.aladinserver.controller.response.DropdownResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DropdownController {
    private final DropdownService dropdownService;

    public DropdownController(DropdownService dropdownService) {
        this.dropdownService = dropdownService;
    }

    @GetMapping("/categories")
    public ResponseEntity<AladinResponse<DropdownResponse>> getCategories() {
        DropdownResponse response = dropdownService.getCategories();
        return ResponseEntity.ok(AladinResponse.success(SuccessCode.OK, response));
    }
}
