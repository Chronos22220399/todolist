package com.ess.todolist.entity;

import com.ess.todolist.custom.CategoryCode;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.FieldFill;

import lombok.Data;

@TableName("task_catogory")
@Data
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
}
