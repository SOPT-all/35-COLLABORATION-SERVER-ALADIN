package com.aladin.aladinserver.repository;

import com.aladin.aladinserver.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MainviewRepository extends JpaRepository<Book, Long> {
    // isSelectedByEditor가 true인 책 조회 (EDITOR 타입 처리)
    List<Book> findByIsSelectedByEditorTrue();

    // parentId를 통해 Category에 속한 책 조회
    @Query("SELECT b FROM Book b WHERE b.category.parentId = :parentId")
    List<Book> findByCategoryParentId(@Param("parentId") Long parentId);
}
