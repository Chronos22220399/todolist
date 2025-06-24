package com.ess.todolist.exception;

import com.ess.todolist.exception.BusinessException;
import com.ess.todolist.custom.Error;
import com.ess.todolist.custom.ApiResult;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ApiResult<?>> handleBusinessException(BusinessException ex) {
    ApiResult<?> apiResult = new ApiResult<>();
    ApiResult.ErrorInfo errorInfo = new ApiResult.ErrorInfo();

    errorInfo.setError(ex.getErrorCode());
    errorInfo.setDetails(ex.getMessage());

    apiResult.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
    apiResult.setError(Optional.of(errorInfo));

    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(apiResult);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResult<?>> handleValidationException(MethodArgumentNotValidException ex) {
    ApiResult<?> apiResult = new ApiResult<>();
    ApiResult.ErrorInfo errorInfo = new ApiResult.ErrorInfo();

    errorInfo.setError(Error.VALIDATION_ERROR.getCode());
    errorInfo.setDetails(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

    apiResult.setStatusCode(HttpStatus.BAD_REQUEST.value());
    apiResult.setError(Optional.of(errorInfo));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(apiResult);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResult<?>> handleOtherExceptions(Exception ex) {
    ApiResult<?> apiResult = new ApiResult<>();
    ApiResult.ErrorInfo errorInfo = new ApiResult.ErrorInfo();

    errorInfo.setError(Error.INTERNAL_ERROR.getCode());
    errorInfo.setDetails(ex.getMessage());

    apiResult.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    apiResult.setError(Optional.of(errorInfo));

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(apiResult);
  }
}
