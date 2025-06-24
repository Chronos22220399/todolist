package com.ess.todolist.entity;

import com.ess.todolist.custom.CategoryCode;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.FieldFill;

@TableName("task_catogory")
public class TaskCategory {
  @TableId(value = "category_id", type = IdType.AUTO)
  private Integer categoryId;

  private CategoryCode code;

  private String name;

  private String description;

  @TableField("created_by")
  private Integer createdBy;

  @TableField(value = "created_at", fill = FieldFill.INSERT)
  private LocalDateTime createdAt;

  @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updatedAt;

  @TableField("is_deleted")
  @TableLogic
  private Boolean isDeleted;

  // Getter 和 Setter 方法
  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryCode getCode() {
    return code;
  }

  public void setCode(CategoryCode code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
