package com.dev.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다.");

    private final String errorMsg;

    public String getErrorMsg(Objects... arg) {
        return String.format(errorMsg, arg);
    }

}
