package com.dev.common.exception;

import com.dev.common.response.ErrorCode;
import lombok.Getter;

import java.util.Iterator;

@Getter
public class BaseException extends RuntimeException {

    private ErrorCode errorCode; // TODO, ErrorCode Enum 정의하기

    public BaseException() {
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
