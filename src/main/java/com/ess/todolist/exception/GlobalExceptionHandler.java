package com.ess.todolist.exception;

import com.ess.todolist.exception.BusinessException;
import com.ess.todolist.custom.Error;
import com.ess.todolist.custom.ApiResult;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @Operation(summary = "处理业务异常", description = "捕获并处理系统中的业务异常，返回统一的错误响应")
  @ApiResponse(responseCode = "422", description = "业务异常导致的请求无法处理")
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

  @Operation(summary = "处理验证异常", description = "捕获并处理参数验证失败的异常，返回统一的错误响应")
  @ApiResponse(responseCode = "400", description = "请求参数验证失败")
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

  @Operation(summary = "处理其他未捕获异常", description = "捕获并处理系统中未明确处理的异常，返回统一的错误响应")
  @ApiResponse(responseCode = "500", description = "服务器内部错误")
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
