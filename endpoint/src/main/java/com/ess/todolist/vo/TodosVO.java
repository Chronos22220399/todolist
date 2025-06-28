package com.ess.todolist.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodosVO {

  private Integer taskId;

  private String title;

  private String catogory;

  private String description;

  private String status;

  private long priority;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private Boolean isCompleted;
}
