package com.ess.todolist.service;

import com.ess.todolist.dto.TodoCreateDTO;
import com.ess.todolist.vo.TodoVO;
import io.swagger.v3.oas.annotations.Operation;

public interface TodoService {

  @Operation(summary = "创建待办事项", description = "根据提供的待办事项数据创建一个新的待办事项，并返回其详细信息")
  TodoVO createTodo(TodoCreateDTO dto);
}
