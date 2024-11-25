package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.CustomException;
import com.aladin.aladinserver.common.SuccessCode;
import com.aladin.aladinserver.controller.response.AladinResponse;
import com.aladin.aladinserver.controller.response.BookResponse;
import com.aladin.aladinserver.service.BookService;
import com.aladin.aladinserver.service.response.BooksResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/main")
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

    @GetMapping
    public AladinResponse<BooksResponse> getBooks(@RequestParam Sort sort) {
        return AladinResponse.success(SuccessCode.OK, bookService.getBooks(sort));
    }
}
