package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.exceptions.NotFoundException;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcControllerExceptionHandler {
    @GrpcExceptionHandler(NotFoundException.class)
    public StatusRuntimeException handleNotFoundException(NotFoundException exception) {
        Status status = Status.NOT_FOUND.withDescription(exception.getMessage()).withCause(exception);
        return status.asRuntimeException();
    }

    @GrpcExceptionHandler(Exception.class)
    public StatusException handleOtherException(Exception exception) {
        Status status = Status.UNKNOWN.withDescription(exception.getMessage()).withCause(exception);
        return status.asException();
    }
}
