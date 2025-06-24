package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatus {

  COMPLETED("Completed"),
  NOT_COMPLETED("Not Completed"),
  ARCHIVED("Archived");

  @EnumValue
  private final String value;

  TaskStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }
}
