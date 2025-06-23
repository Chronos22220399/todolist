package com.ess.todolist.exception;

import com.ess.todolist.custom.Error;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "业务异常类，用于表示系统中的业务错误")
public class BusinessException extends RuntimeException {

  @ApiModelProperty(value = "业务错误码", example = "NOT_FOUND")
  private final String errorCode;

  public BusinessException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public BusinessException(Error e) {
    super(e.getMessage());
    this.errorCode = e.getCode();
  }

  public String getErrorCode() {
    return errorCode;
  }
}
