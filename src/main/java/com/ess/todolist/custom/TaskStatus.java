package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "任务状态枚举，表示待办事项的当前状态")
public enum TaskStatus {
  @Schema(description = "任务已完成", example = "Completed")
  COMPLETED("Completed"),

  @Schema(description = "任务未完成", example = "Not Completed")
  NOT_COMPLETED("Not Completed"),

  @Schema(description = "任务已归档", example = "Archived")
  ARCHIVED("Archived");

  @EnumValue
  private final String value;

  TaskStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
