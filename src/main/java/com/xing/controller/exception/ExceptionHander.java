package com.xing.controller.exception;

import com.xing.entity.Result;
import com.xing.util.exception.InvalidNumberException;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHander extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidNumberException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        Result ret = new Result(false, 400, ex.getMessage());
        return handleExceptionInternal(ex, ret, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
