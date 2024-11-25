package com.aladin.aladinserver.repository;

import com.aladin.aladinserver.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // isSelectedByEditor가 true인 책 조회 (EDITOR 타입 처리)
    List<Book> findByIsSelectedByEditorTrue();

    // category name으로 책 조회
    @Query("SELECT b FROM Book b JOIN FETCH b.category c WHERE LOWER(c.name) = LOWER(:categoryName)")
    List<Book> findBooksByCategoryName(@Param("categoryName") String categoryName);
}
