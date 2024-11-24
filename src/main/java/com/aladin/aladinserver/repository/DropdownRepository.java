package com.aladin.aladinserver.repository;

import com.aladin.aladinserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropdownRepository extends JpaRepository<Category, Long>{
}
