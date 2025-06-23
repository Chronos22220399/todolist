package com.ess.todolist.exception;

import com.ess.todolist.exception.BusinessException;
import com.ess.todolist.custom.Error;
import com.ess.todolist.custom.ApiResult;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Optional;

@Api(tags = "全局异常处理器")
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ApiOperation(value = "处理业务异常", notes = "捕获并处理系统中的业务异常，返回统一的错误响应")
  @ApiResponses({
      @ApiResponse(code = 422, message = "业务异常导致的请求无法处理")
  })
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

  @ApiOperation(value = "处理验证异常", notes = "捕获并处理参数验证失败的异常，返回统一的错误响应")
  @ApiResponses({
      @ApiResponse(code = 400, message = "请求参数验证失败")
  })
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

  @ApiOperation(value = "处理其他未捕获异常", notes = "捕获并处理系统中未明确处理的异常，返回统一的错误响应")
  @ApiResponses({
      @ApiResponse(code = 500, message = "服务器内部错误")
  })
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
