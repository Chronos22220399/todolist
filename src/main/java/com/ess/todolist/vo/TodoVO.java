package com.ess.todolist.vo;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "待办事项视图对象，用于返回待办事项的详细信息")
public class TodoVO {

  @ApiModelProperty(value = "任务ID，唯一标识待办事项", example = "101")
  private long taskId;

  @ApiModelProperty(value = "待办事项的标题", example = "买菜")
  private String title;

  @ApiModelProperty(value = "待办事项所属分类名称", example = "家庭")
  private String catogory;

  @ApiModelProperty(value = "待办事项的详细描述", example = "购买新鲜蔬菜")
  private String description;

  @ApiModelProperty(value = "待办事项的状态。可能的值：\n" +
      "Completed - 已完成\n" +
      "Not Completed - 未完成\n" +
      "Archived - 已归档", example = "Not Completed")
  private String status;

  @ApiModelProperty(value = "待办事项的优先级。可能的值：\n" +
      "0 - LOW（低优先级）\n" +
      "1 - MIDDLE（中优先级）\n" +
      "2 - HIGH（高优先级）", example = "2")
  private int priority;

  @ApiModelProperty(value = "待办事项的创建时间", example = "2023-10-01T10:00:00")
  private LocalDateTime createdAt;

  @ApiModelProperty(value = "待办事项的最后更新时间", example = "2023-10-02T15:30:00")
  private LocalDateTime updatedAt;
}
