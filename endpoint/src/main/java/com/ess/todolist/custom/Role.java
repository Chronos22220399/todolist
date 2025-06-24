package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

  ADMIN("Admin"),
  USER("User"),
  MODERATOR("Moderator");

  @EnumValue
  private final String value;

  Role(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }
}
