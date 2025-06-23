package com.ess.todolist.custom;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "分类代码枚举，表示待办事项的分类类型")
public enum CategoryCode {
  @Schema(description = "通用分类", example = "General")
  GENERAL("General"),

  @Schema(description = "艾宾浩斯记忆分类", example = "Ebbinghaus")
  EBBINGHAUS("Ebbinghaus");

  @EnumValue
  private final String value;

  CategoryCode(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
