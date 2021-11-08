package com.xing.controller.exceptionhandlers;

import com.xing.constant.ErrorMessages;
import com.xing.entity.Result;
import com.xing.util.exception.InvalidNumberException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidNumberException.class)
    protected ResponseEntity<Object> handleInvalidNumberError(RuntimeException ex, WebRequest request) {
        Result ret = new Result(false, 400, ex.getMessage());
        return handleExceptionInternal(ex, ret, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleUnexpectErrors(RuntimeException ex, WebRequest request) {
        Result ret = new Result(false, 500, ErrorMessages.UNEXPECTED_ERROR);
        return handleExceptionInternal(ex, ret, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
