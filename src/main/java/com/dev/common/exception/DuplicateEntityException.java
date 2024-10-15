package com.dev.common.exception;

import com.dev.common.response.ErrorCode;

public class DuplicateEntityException extends BaseException {


    public DuplicateEntityException() {
        super(ErrorCode.ENTITY_DUPLICATE_OCCUR);
    }

    public DuplicateEntityException(String message) {
        super(ErrorCode.ENTITY_DUPLICATE_OCCUR, message);
    }

}
