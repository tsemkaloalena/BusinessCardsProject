package com.tsemkalo.businesscards.exceptions.handler;

import com.tsemkalo.businesscards.configuration.constants.QueueConstants;
import com.tsemkalo.businesscards.dto.ErrorMessageDTO;
import com.tsemkalo.businesscards.exceptions.AuthenticationCredentialsReadingException;
import com.tsemkalo.businesscards.exceptions.AuthorizationErrorException;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import io.grpc.Status;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
@EnableRabbit
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private RabbitTemplate template;

    @ExceptionHandler({AuthenticationCredentialsReadingException.class, IOException.class})
    public ResponseEntity<Object> handleInternalErrorException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, true);
    }

    @ExceptionHandler({IncorrectDataException.class, IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST, false);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND, false);
    }

    @ExceptionHandler({AuthorizationErrorException.class, AuthenticationException.class})
    public ResponseEntity<Object> handleUnauthorizedErrorException(RuntimeException exception, WebRequest request) {
        return makeResponseEntity(exception.getMessage(), HttpStatus.UNAUTHORIZED, true);
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
            return makeResponseEntity(status.getCause().getMessage(), httpStatus, true);
        }
        return makeResponseEntity( status.getDescription(), httpStatus, true);
    }

    private ResponseEntity<Object> makeResponseEntity(String message, HttpStatus httpStatus, boolean sendToAdmin) {
        sendErrorToAdmin(httpStatus.value(), message);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Calendar.getInstance());
        body.put("message", message);
        return new ResponseEntity<>(body, httpStatus);
    }

    private void sendErrorToAdmin(Integer code, String text) {
        template.convertAndSend(QueueConstants.SEND_ERROR_TO_ADMIN, new ErrorMessageDTO(code, text));
    }
}
