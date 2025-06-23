package com.ess.todolist.custom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "错误枚举，表示系统可能返回的错误类型")
public enum Error {

  @ApiModelProperty(value = "资源未找到", example = "NOT_FOUND")
  NOT_FOUND("NOT_FOUND", "资源未找到"),

  @ApiModelProperty(value = "用户名已存在", example = "USER_EXISTS")
  USER_EXISTS("USER_EXISTS", "用户名已存在"),

  @ApiModelProperty(value = "服务器内部错误", example = "INTERNAL_ERROR")
  INTERNAL_ERROR("INTERNAL_ERROR", "服务器内部错误"),

  @ApiModelProperty(value = "验证失败", example = "VALIDATION_ERROR")
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
