package com.ess.todolist.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoVO {

  private long taskId;

  private String title;

  private String catogory;

  private String description;

  private String status;

  private int priority;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
