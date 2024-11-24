package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.ErrorCode;
import com.aladin.aladinserver.common.SuccessCode;
import com.aladin.aladinserver.controller.response.AladinResponse;
import com.aladin.aladinserver.controller.response.MainviewResponse;
import com.aladin.aladinserver.service.MainviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainviewController {
    private final MainviewService mainviewService;

    public MainviewController(MainviewService mainviewService) {
        this.mainviewService = mainviewService;
    }

    @GetMapping("/api/v1/books")
    public AladinResponse<List<MainviewResponse>> getBooksByType(@RequestParam String type) {
        try {
            List<MainviewResponse> books = mainviewService.getBooksByType(type);
            return AladinResponse.success(SuccessCode.OK, books);
        } catch (IllegalArgumentException e) {
            return AladinResponse.fail(ErrorCode.BAD_REQUEST);
        }
    }
}
