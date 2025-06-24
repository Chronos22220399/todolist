package com.ess.todolist.custom;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Error {

  NOT_FOUND("NOT_FOUND", "资源未找到"),
  USER_EXISTS("USER_EXISTS", "用户名已存在"),
  INTERNAL_ERROR("INTERNAL_ERROR", "服务器内部错误"),
  VALIDATION_ERROR("VALIDATION_ERROR", "验证失败");

  private final String code;
  private final String message;

  Error(String code, String defaultMessage) {
    this.code = code;
    this.message = defaultMessage;
  }

  @JsonValue
  public String getCode() {
    return code;
  }

  @JsonValue
  public String getMessage() {
    return message;
  }
}
