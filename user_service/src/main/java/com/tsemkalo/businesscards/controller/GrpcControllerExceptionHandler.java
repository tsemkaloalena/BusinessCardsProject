package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.LinkExpiredException;
import com.tsemkalo.businesscards.exceptions.UserExistsException;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@GrpcAdvice
public class GrpcControllerExceptionHandler {
    @GrpcExceptionHandler(UsernameNotFoundException.class)
    public StatusRuntimeException handleUsernameNotFoundException(UsernameNotFoundException exception) {
        Status status = Status.NOT_FOUND.withDescription("Username " + exception.getMessage() + " doesn't exist").withCause(exception);
        return status.asRuntimeException();
    }

    @GrpcExceptionHandler(LinkExpiredException.class)
    public StatusRuntimeException handleLinkExpiredException(LinkExpiredException exception) {
        Status status = Status.PERMISSION_DENIED.withDescription(exception.getMessage()).withCause(exception);
        return status.asRuntimeException();
    }

    @GrpcExceptionHandler(IncorrectDataException.class)
    public StatusRuntimeException handleIncorrectDataException(IncorrectDataException exception) {
        Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage()).withCause(exception);
        return status.asRuntimeException();
    }

    @GrpcExceptionHandler(UserExistsException.class)
    public StatusRuntimeException handleUserExistsException(UserExistsException exception) {
        Status status = Status.ALREADY_EXISTS.withDescription(exception.getMessage()).withCause(exception);
        return status.asRuntimeException();
    }

    @GrpcExceptionHandler(Exception.class)
    public StatusException handleOtherException(Exception exception) {
        Status status = Status.UNKNOWN.withDescription(exception.getMessage()).withCause(exception);
        return status.asException();
    }
}
