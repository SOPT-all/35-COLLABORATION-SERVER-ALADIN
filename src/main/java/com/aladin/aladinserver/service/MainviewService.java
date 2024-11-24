package com.aladin.aladinserver.service;

import com.aladin.aladinserver.controller.response.MainviewResponse;
import com.aladin.aladinserver.entity.Book;
import com.aladin.aladinserver.repository.MainviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MainviewService {
    private final MainviewRepository mainviewRepository;

    public MainviewService(MainviewRepository mainviewRepository) {
        this.mainviewRepository = mainviewRepository;
    }

    // type이랑 parentId 매핑
    private static final Map<String, Long> TYPE_TO_PARENT_ID = Map.of(
            "FOREIGN", 2L,
            "EBOOK", 3L,
            "ALADINGOODS", 7L
    );

    public List<MainviewResponse> getBooksByType(String type) {
        List<Book> books;

        if (type.equals("EDITOR")) {
            // isSelectedByEditor가 true인 책 조회
            books = mainviewRepository.findByIsSelectedByEditorTrue();
        } else if (TYPE_TO_PARENT_ID.containsKey(type)) {
            // type 값을 parentId로 매핑하고, 해당 parentId에 속한 책 조회
            Long parentId = TYPE_TO_PARENT_ID.get(type);
            books = mainviewRepository.findByCategoryParentId(parentId);
        } else {
            // 유효하지 않은 type 값 처리
            throw new IllegalArgumentException("유효하지 않은 type 값입니다. 대문자로 입력해주세요.");
        }

        return books.stream()
                .map(book -> new MainviewResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getImageUrl()
                ))
                .collect(Collectors.toList());

    }
}
