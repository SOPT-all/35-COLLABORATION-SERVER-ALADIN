package com.aladin.aladinserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parent_id", nullable = true)
    private Long parentId;

    @Column(name = "style", nullable = false)
    @Enumerated(EnumType.STRING)
    private TextStyle style;

    @Column(name = "group_name", nullable = true) // 새로운 필드 추가
    private String groupName;

    protected Category() {
    }

    public String getName() {
        return name;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isBold() {
        return this.style == TextStyle.BOLD;
    }
}
