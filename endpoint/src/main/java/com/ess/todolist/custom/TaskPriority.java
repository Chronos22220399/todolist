package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskPriority {

  HIGH(2),
  MIDDLE(1),
  LOW(0);

  @EnumValue
  private final int value;

  TaskPriority(int value) {
    this.value = value;
  }

  @JsonValue
  public int getValue() {
    return this.value;
  }
}
