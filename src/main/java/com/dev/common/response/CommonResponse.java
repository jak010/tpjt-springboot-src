package com.dev.common.response;

import lombok.*;

import javax.print.DocFlavor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private Result result;
    private String message;
    private String errorCode;
    public T data;


    enum Result {
        SUCCESS, FAIL;

    }

    public static CommonResponse<?> fail(String errorCode, String message) {
        return CommonResponse.builder()
                .result(Result.FAIL)
                .errorCode(errorCode)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.<T>builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();

    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }
}
