package com.ess.todolist.custom;

import lombok.Data;

import java.util.Optional;

@Data
public class ApiResult<T> {

  private Integer statusCode;

  private Optional<ErrorInfo> error = Optional.empty();

  private T data;

  @Data
  public static class ErrorInfo {

    private String error;

    private String details;
  }
}
