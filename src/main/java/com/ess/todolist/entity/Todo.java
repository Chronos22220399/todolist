package com.ess.todolist.entity;

import com.ess.todolist.custom.TaskStatus;
import com.ess.todolist.custom.TaskPriority;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.FieldFill;

import lombok.Data;

@TableName("todo")
@Data
public class Todo {
  @TableId(value = "task_id", type = IdType.AUTO)
  private Integer taskId; // 主键，自动递增

  private String title; // 任务标题

  @TableField("catogory_id")
  private Integer categoryId; // 分类ID

  private String description; // 任务详细描述

  private TaskStatus status = TaskStatus.NOT_COMPLETED; // 任务状态：Completed, Not Completed, Archived

  private TaskPriority priority = TaskPriority.LOW; // 任务优先级：0 - 低, 1 - 中, 2 - 高

  @TableField("created_by")
  private Integer createdBy; // 创建任务的用户ID

  @TableField(value = "created_at", fill = FieldFill.INSERT)
  private LocalDateTime createdAt; // 任务创建时间

  @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updatedAt; // 任务最后更新时间

  @TableField("is_deleted")
  @TableLogic
  private Boolean isDeleted; // 是否被删除
}
