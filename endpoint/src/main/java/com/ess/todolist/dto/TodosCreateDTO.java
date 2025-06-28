package com.ess.todolist.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.ess.todolist.custom.TaskPriority;

@Data
public class TodosCreateDTO {

  @NotBlank(message = "标题不能为空")
  private String title;

  @NotNull(message = "分类代码不能为空")
  private Integer categoryId;

  private String description;

  @NotNull(message = "优先级不能为空")
  private TaskPriority priority;

  @NotNull(message = "创建者ID不能为空")
  private Integer createdBy;
}
