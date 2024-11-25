package com.aladin.aladinserver.controller.response;


import com.aladin.aladinserver.common.ErrorCode;
import com.aladin.aladinserver.common.SuccessCode;
import com.fasterxml.jackson.annotation.JsonInclude;

public class AladinResponse<T> {

    private final int code;
    private final String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    public AladinResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AladinResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> AladinResponse<T> success(SuccessCode success) {
        return new AladinResponse<>(success.getHttpStatus().value(), success.getMessage());
    }


    public static <T> AladinResponse<T> success(SuccessCode success, T data) {
        return new AladinResponse<>(success.getHttpStatus().value(), success.getMessage(), data);
    }

    public static <T> AladinResponse<T> fail(ErrorCode error) {
        return new AladinResponse<>(error.getHttpStatus().value(), error.getMessage());
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
