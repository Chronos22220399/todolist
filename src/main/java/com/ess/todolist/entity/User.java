package com.ess.todolist.entity;

import com.ess.todolist.custom.Role;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.FieldFill;

import lombok.Data;

@TableName("user")
@Data
public class User {
  @TableId(value = "user_id", type = IdType.AUTO)
  private long userId;

  private String username;

  @TableField("hashed_password")
  private String hashedPassword;

  private String email;

  @TableField(value = "created_at", fill = FieldFill.INSERT)
  private LocalDateTime createdAt;

  private Role role;

  @TableField("is_deleted")
  @TableLogic
  private Boolean isDeleted;
}
