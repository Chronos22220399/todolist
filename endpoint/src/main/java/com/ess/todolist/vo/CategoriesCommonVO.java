package com.ess.todolist.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoriesCommonVO {

  private Integer categoryId;

  private String name;

  private String description;
}
