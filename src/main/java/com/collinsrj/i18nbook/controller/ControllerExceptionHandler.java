package com.collinsrj.i18nbook.controller;

import com.collinsrj.i18nbook.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ResourceBundle;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    private static final String ERROR_UNKNOWN = "error.unknown";

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Error unhandledException(Exception ex, WebRequest request) {
        Error message = new Error();
        ResourceBundle bundle = ResourceBundle.getBundle(
                "com.collinsrj.i18nbook.controller.Messages", request.getLocale());
        message.setMessage(bundle.getString(ERROR_UNKNOWN));
        return message;
    }
}