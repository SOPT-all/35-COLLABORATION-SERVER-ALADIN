package com.aladin.aladinserver.service;

import com.aladin.aladinserver.common.CustomException;
import com.aladin.aladinserver.common.ErrorCode;
import com.aladin.aladinserver.controller.response.BookResponse;
import com.aladin.aladinserver.entity.Book;
import com.aladin.aladinserver.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> getBooksByType(String type) {
        List<Book> books;

        if (type.equals("EDITOR")) {
            // isSelectedByEditor가 true인 책 조회
            books = bookRepository.findByIsSelectedByEditorTrue();
        } else {
            // type을 categoryName으로 사용해 조회
            books = bookRepository.findBooksByCategoryName(type);
            // 조회된 결과가 없는 경우 예외 발생
            if (books.isEmpty()) {
                throw new CustomException(ErrorCode.INVALID_CATEGORY_TYPE);
            }
        }

        // BookResponse의 fromEntity 메서드 사용
        return books.stream()
                .map(BookResponse::fromEntity)
                .collect(Collectors.toList());

    }
}
