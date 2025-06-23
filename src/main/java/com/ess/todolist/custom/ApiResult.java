package com.ess.todolist.custom;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Optional;

@Data
public class ApiResult<T> {

  @ApiModelProperty(value = "HTTP状态码", example = "200")
  private Integer statusCode;

  @ApiModelProperty(value = "错误详情，如果请求失败则包含错误信息")
  private Optional<ErrorInfo> error = Optional.empty();

  @ApiModelProperty(value = "成功返回的数据")
  private T data;

  @Data
  @ApiModel(description = "错误信息详情")
  public static class ErrorInfo {

    @ApiModelProperty(value = "业务错误码/类型", example = "NOT_FOUND")
    private String error;

    @ApiModelProperty(value = "错误详情", example = "资源未找到")
    private String details;
  }
}
