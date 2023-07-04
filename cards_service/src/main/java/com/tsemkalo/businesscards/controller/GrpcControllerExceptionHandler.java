package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.AlreadyExistsException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
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

	@GrpcExceptionHandler(AccessDeniedException.class)
	public StatusRuntimeException handleAccessDeniedException(AccessDeniedException exception) {
		Status status = Status.PERMISSION_DENIED.withDescription(exception.getMessage()).withCause(exception);
		return status.asRuntimeException();
	}

	@GrpcExceptionHandler(IncorrectDataException.class)
	public StatusRuntimeException handleIncorrectDataException(IncorrectDataException exception) {
		Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage()).withCause(exception);
		return status.asRuntimeException();
	}

	@GrpcExceptionHandler(AlreadyExistsException.class)
	public StatusRuntimeException handleAlreadyExistsException(AlreadyExistsException exception) {
		Status status = Status.ALREADY_EXISTS.withDescription(exception.getMessage()).withCause(exception);
		return status.asRuntimeException();
	}

	@GrpcExceptionHandler(Exception.class)
	public StatusException handleOtherException(Exception exception) {
		Status status = Status.UNKNOWN.withDescription(exception.getMessage()).withCause(exception);
		return status.asException();
	}
}
