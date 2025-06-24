package com.ess.todolist.exception;

import java.lang.RuntimeException;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
