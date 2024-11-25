package com.aladin.aladinserver.controller;

import com.aladin.aladinserver.common.CustomException;
import com.aladin.aladinserver.controller.response.AladinResponse;
import com.aladin.aladinserver.common.ErrorCode;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AladinResponse<Void> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return AladinResponse.fail(ErrorCode.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(CustomException.class)
    public AladinResponse<Void> handleCustomException(CustomException e) {
        return AladinResponse.fail(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    public AladinResponse<Void> handleException(Exception e) {
        return AladinResponse.fail(ErrorCode.BAD_REQUEST);
    }
}
