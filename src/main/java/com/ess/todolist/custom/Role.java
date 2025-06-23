package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户角色枚举，表示用户的权限级别")
public enum Role {

  @ApiModelProperty(value = "管理员角色，拥有最高权限", example = "Admin")
  ADMIN("Admin"),

  @ApiModelProperty(value = "普通用户角色，拥有基本权限", example = "User")
  USER("User"),

  @ApiModelProperty(value = "版主角色，拥有管理权限", example = "Moderator")
  MODERATOR("Moderator");

  @EnumValue
  private final String value;

  Role(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
