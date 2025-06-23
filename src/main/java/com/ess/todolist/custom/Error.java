package com.ess.todolist.custom;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "错误枚举，表示系统可能返回的错误类型")
public enum Error {

  @Schema(description = "资源未找到", example = "NOT_FOUND")
  NOT_FOUND("NOT_FOUND", "资源未找到"),

  @Schema(description = "用户名已存在", example = "USER_EXISTS")
  USER_EXISTS("USER_EXISTS", "用户名已存在"),

  @Schema(description = "服务器内部错误", example = "INTERNAL_ERROR")
  INTERNAL_ERROR("INTERNAL_ERROR", "服务器内部错误"),

  @Schema(description = "验证失败", example = "VALIDATION_ERROR")
  VALIDATION_ERROR("VALIDATION_ERROR", "验证失败");

  private final String code;
  private final String message;

  Error(String code, String defaultMessage) {
    this.code = code;
    this.message = defaultMessage;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
