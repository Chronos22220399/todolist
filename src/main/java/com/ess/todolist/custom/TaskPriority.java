package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "任务优先级枚举，表示待办事项的优先级")
public enum TaskPriority {
  @Schema(description = "高优先级", example = "2")
  HIGH(2),

  @Schema(description = "中优先级", example = "1")
  MIDDLE(1),

  @Schema(description = "低优先级", example = "0")
  LOW(0);

  @EnumValue
  private final int value;

  TaskPriority(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
