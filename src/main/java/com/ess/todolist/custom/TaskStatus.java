package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "任务状态枚举，表示待办事项的当前状态")
public enum TaskStatus {

  @ApiModelProperty(value = "任务已完成", example = "Completed")
  COMPLETED("Completed"),

  @ApiModelProperty(value = "任务未完成", example = "Not Completed")
  NOT_COMPLETED("Not Completed"),

  @ApiModelProperty(value = "任务已归档", example = "Archived")
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
