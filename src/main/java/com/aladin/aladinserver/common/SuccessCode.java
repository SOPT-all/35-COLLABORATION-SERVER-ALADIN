package com.aladin.aladinserver.common;

import org.springframework.http.HttpStatus;

public enum SuccessCode {

    OK(HttpStatus.OK, "요청이 성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    private SuccessCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
