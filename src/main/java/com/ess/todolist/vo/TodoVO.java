package com.ess.todolist.vo;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Data
public class TodoVO {

  @Schema(description = "任务ID，唯一标识待办事项", example = "101")
  private long taskId;

  @Schema(description = "待办事项的标题", example = "买菜")
  private String title;

  @Schema(description = "待办事项所属分类名称", example = "家庭")
  private String catogory;

  @Schema(description = "待办事项的详细描述", example = "购买新鲜蔬菜")
  private String description;

  @Schema(description = "待办事项的状态。可能的值：\n" +
      "Completed - 已完成\n" +
      "Not Completed - 未完成\n" +
      "Archived - 已归档", example = "Not Completed")
  private String status;

  @Schema(description = "待办事项的优先级。可能的值：\n" +
      "0 - LOW（低优先级）\n" +
      "1 - MIDDLE（中优先级）\n" +
      "2 - HIGH（高优先级）", example = "2")
  private int priority;

  @Schema(description = "待办事项的创建时间", example = "2023-10-01T10:00:00")
  private LocalDateTime createdAt;

  @Schema(description = "待办事项的最后更新时间", example = "2023-10-02T15:30:00")
  private LocalDateTime updatedAt;
}
