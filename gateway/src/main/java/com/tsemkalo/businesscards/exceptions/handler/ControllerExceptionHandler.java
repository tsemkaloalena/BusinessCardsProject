package com.tsemkalo.businesscards.exceptions.handler;

import com.tsemkalo.businesscards.exceptions.AuthenticationCredentialsReadingException;
import com.tsemkalo.businesscards.exceptions.AuthorizationErrorException;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import io.grpc.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({AuthenticationCredentialsReadingException.class, IOException.class})
    public ResponseEntity<Object> handleInternalErrorException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({IncorrectDataException.class, IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AuthorizationErrorException.class, AuthenticationException.class})
    public ResponseEntity<Object> handleUnauthorizedErrorException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseEntity<Object> handleOtherException(Exception exception, WebRequest request) {
        Status status = Status.fromThrowable(exception);
        HttpStatus httpStatus;
        switch (status.getCode()) {
            case NOT_FOUND -> httpStatus = HttpStatus.NOT_FOUND;
            case PERMISSION_DENIED -> httpStatus = HttpStatus.FORBIDDEN;
            case INVALID_ARGUMENT -> httpStatus = HttpStatus.BAD_REQUEST;
            case ALREADY_EXISTS -> httpStatus = HttpStatus.CONFLICT;
            default -> httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        if (status.getDescription() == null) {
            return makeResponseEntity(status.getCause().getMessage(), httpStatus);
        }
        return makeResponseEntity( status.getDescription(), httpStatus);
    }

    private ResponseEntity<Object> makeResponseEntity(String message, HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Calendar.getInstance());
        body.put("message", message);
        return new ResponseEntity<>(body, httpStatus);
    }
}
