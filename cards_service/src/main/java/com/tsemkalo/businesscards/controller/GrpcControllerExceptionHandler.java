package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import io.grpc.Status;
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

	@GrpcExceptionHandler(Exception.class)
	public StatusRuntimeException handleInvalidArgumentException(AccessDeniedException exception) {
		Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage()).withCause(exception);
		return status.asRuntimeException();
	}


//	public void handleNotFoundException(RuntimeException exception, io.grpc.stub.StreamObserver<com.google.protobuf.GeneratedMessageV3> responseObserver) {
//		Status status = Status.NOT_FOUND.withDescription(exception.getMessage());
//		responseObserver.onError(status.asRuntimeException());
//	}
//
//	@ExceptionHandler({IOException.class})
//	public void handleInternalErrorException(RuntimeException exception, io.grpc.stub.StreamObserver<com.google.protobuf.GeneratedMessageV3> responseObserver) {
//		Status status = Status.INVALID_ARGUMENT.withDescription(exception.getMessage());
//		responseObserver.onError(status.asRuntimeException());
//	}
}
