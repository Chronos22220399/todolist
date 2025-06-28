package com.ess.todolist.dto;

import lombok.Data;

@Data
public class CategoriesCreateDTO {

  private String name;

  private String description;

  private Integer createdBy;
}
