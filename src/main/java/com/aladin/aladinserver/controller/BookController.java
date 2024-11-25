package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.CustomException;
import com.aladin.aladinserver.common.ErrorCode;
import com.aladin.aladinserver.common.SuccessCode;
import com.aladin.aladinserver.controller.response.AladinResponse;
import com.aladin.aladinserver.controller.response.BookResponse;
import com.aladin.aladinserver.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<AladinResponse<List<BookResponse>>> getBooksByType(@RequestParam String type) {
        try {
            List<BookResponse> books = bookService.getBooksByType(type);
            return ResponseEntity.ok(AladinResponse.success(SuccessCode.OK, books));
        } catch (CustomException e) {
            return ResponseEntity
                    .status(e.getErrorCode().getHttpStatus()) // 예외에 맞는 HTTP 상태 코드 설정
                    .body(AladinResponse.fail(e.getErrorCode()));
        }
    }
}
