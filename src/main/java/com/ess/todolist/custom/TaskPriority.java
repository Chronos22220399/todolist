package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "任务优先级枚举，表示待办事项的优先级")
public enum TaskPriority {

  @ApiModelProperty(value = "高优先级", example = "2")
  HIGH(2),

  @ApiModelProperty(value = "中优先级", example = "1")
  MIDDLE(1),

  @ApiModelProperty(value = "低优先级", example = "0")
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
