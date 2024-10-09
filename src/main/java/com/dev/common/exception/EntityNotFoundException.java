package com.dev.common.exception;

import com.dev.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {


    public EntityNotFoundException() {
        super(ErrorCode.COMMON_INVALID_PARAMETER);
    }


    public EntityNotFoundException(String message) {
        super(ErrorCode.COMMON_INVALID_PARAMETER, message);
    }

}
