package com.ess.todolist.exception;

import com.ess.todolist.custom.Err;

import java.lang.Throwable;

public class BusinessException extends RuntimeException {

  private final String errorCode;

  public BusinessException(String errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public BusinessException(Err e) {
    super(e.getMessage());
    this.errorCode = e.getCode();
  }

  public String getErrorCode() {
    return errorCode;
  }
}
