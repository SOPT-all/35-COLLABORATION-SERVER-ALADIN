package com.aladin.aladinserver.controller;

public enum Sort {
    MEMBERSHIP;

    protected Sort createSort(String sort) {
        return Sort.valueOf(sort);
    }
}
