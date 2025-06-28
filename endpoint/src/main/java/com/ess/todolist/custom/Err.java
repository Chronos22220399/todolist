package com.ess.todolist.custom;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Err {

  NOT_FOUND("NOT_FOUND", "资源未找到"),
  USER_EXISTS("USER_EXISTS", "用户名已存在"),
  INTERNAL_ERROR("INTERNAL_ERROR", "服务器内部错误"),
  VALIDATION_ERROR("VALIDATION_ERROR", "验证失败"),
  DATABASE_ERROR("DATABASE_ERROR", "数据库不可访问"),
  INVALID_ARGUMENT("INVALID_ARGUMENT", "不合法的数据库查询参数");

  private final String code;
  private final String message;

  Err(String code, String defaultMessage) {
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
