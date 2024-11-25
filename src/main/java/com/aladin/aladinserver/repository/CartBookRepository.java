package com.aladin.aladinserver.repository;

import com.aladin.aladinserver.entity.Cart;
import com.aladin.aladinserver.entity.CartBook;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

public interface CartBookRepository extends JpaRepository<CartBook, Long> {
    @Query("select cb from CartBook cb join fetch cb.cart c join fetch cb.book b where c.user.id = :userId")
    List<CartBook> findByCartBookWithCartAndBookByUserId(long userId);
}
