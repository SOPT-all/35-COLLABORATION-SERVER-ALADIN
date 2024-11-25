package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.CustomException;
import com.aladin.aladinserver.common.ErrorCode;
import org.springframework.core.convert.converter.Converter;

public class SortConverter implements Converter<String, Sort> {
    @Override
    public Sort convert(String source) {
        Sort sort;
        try {
            sort = Sort.valueOf(source.toUpperCase());
        } catch (Exception e) {
            throw new CustomException(ErrorCode.BAD_REQUEST_PARAM);
        }
        return sort;
    }
}
