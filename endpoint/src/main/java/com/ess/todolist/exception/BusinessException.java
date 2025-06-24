package com.ess.todolist.exception;

import com.ess.todolist.custom.Error;

public class BusinessException extends RuntimeException {

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
