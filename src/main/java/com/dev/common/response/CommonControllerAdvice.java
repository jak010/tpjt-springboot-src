package com.dev.common.response;

import com.dev.common.exception.BaseException;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class CommonControllerAdvice {

    /**
     * Http Status, 200
     * - 시스템은 이상없고, 비즈니스 로직 처리에서 에러가 발생함
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = {BaseException.class})
    public CommonResponse<?> onBaseException(
            BaseException e
    ) {
        return CommonResponse.fail(e.getErrorCode().name(), e.getMessage());

    }

}
