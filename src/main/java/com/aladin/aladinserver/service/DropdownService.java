package com.aladin.aladinserver.service;

import com.aladin.aladinserver.controller.response.DropdownResponse;
import com.aladin.aladinserver.entity.Category;
import com.aladin.aladinserver.entity.TextStyle;
import com.aladin.aladinserver.repository.DropdownRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DropdownService {

    private final DropdownRepository dropdownRepository;

    public DropdownService(DropdownRepository dropdownRepository) {
        this.dropdownRepository = dropdownRepository;
    }


    public DropdownResponse getCategories() {
        //모든 카테고리들을 db에서 조회
        List<Category> allCategories = dropdownRepository.findAll();

        //parent id 기준으로 그룹핑, 순서 보장
        Map<String, List<String>> categories = allCategories.stream()
                .filter(category -> category.getParentId() != null)
                .collect(Collectors.groupingBy(
                        Category::getGroupName, // 여기서 groupName 기준으로 그룹핑
                        LinkedHashMap::new, // 순서 보장
                        Collectors.mapping(Category::getName, Collectors.toList()) //각 그룹(domesticBooks 등등)의 리스트 생성
                ));

        //bold 카테고리 필터링 (순서 상관없음)
        List<String> boldCategories = allCategories.stream()
                .filter(Category::isBold) //BOLD된 카테고리만 필터링
                .map(Category::getName) //이름만 추출
                .toList();

        return new DropdownResponse(categories, boldCategories);
    }
    }

