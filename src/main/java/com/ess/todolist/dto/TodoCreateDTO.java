package com.ess.todolist.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.ess.todolist.custom.TaskPriority;
import com.ess.todolist.custom.CategoryCode;

@Data
@ApiModel(description = "待办事项创建请求数据传输对象")
public class TodoCreateDTO {

  @ApiModelProperty(value = "待办事项的标题", example = "买菜", required = true)
  @NotBlank(message = "标题不能为空")
  private String title;

  @ApiModelProperty(value = "分类代码，用于标识待办事项所属的分类。可能的值：\n" +
      "General - 通用分类\n" +
      "Ebbinghaus - 艾宾浩斯记忆分类", example = "General", required = true)
  @NotNull(message = "分类代码不能为空")
  private CategoryCode categoryCode;

  @ApiModelProperty(value = "待办事项的详细描述", example = "购买新鲜蔬菜")
  private String description;

  @ApiModelProperty(value = "待办事项的优先级。可能的值：\n" +
      "0 - LOW（低优先级）\n" +
      "1 - MIDDLE（中优先级）\n" +
      "2 - HIGH（高优先级）", example = "2", required = true)
  @NotNull(message = "优先级不能为空")
  private TaskPriority priority;

  @ApiModelProperty(value = "创建者的用户ID", example = "1001", required = true)
  @NotNull(message = "创建者ID不能为空")
  private long createdBy;
}
