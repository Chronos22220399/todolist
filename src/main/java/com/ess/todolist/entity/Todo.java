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

@TableName("todo")
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

  // Getter 和 Setter 方法
  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public TaskPriority getPriority() {
    return priority;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}
