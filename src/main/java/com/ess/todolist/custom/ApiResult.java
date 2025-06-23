package com.ess.todolist.custom;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@Data
@Schema(description = "通用API响应结果")
public class ApiResult<T> {

  @Schema(description = "HTTP状态码", example = "200")
  private Integer statusCode;

  @Schema(description = "错误详情，如果请求失败则包含错误信息")
  private Optional<ErrorInfo> error = Optional.empty();

  @Schema(description = "成功返回的数据")
  private T data;

  @Data
  @Schema(description = "错误信息详情")
  public static class ErrorInfo {

    @Schema(description = "业务错误码/类型", example = "NOT_FOUND")
    private String error;

    @Schema(description = "错误详情", example = "资源未找到")
    private String details;
  }
}
