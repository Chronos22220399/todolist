package com.ess.todolist.service;

import com.ess.todolist.dto.TodoCreateDTO;
import com.ess.todolist.vo.TodoVO;
import io.swagger.annotations.ApiOperation;

public interface TodoService {

  @ApiOperation(value = "创建待办事项", notes = "根据提供的待办事项数据创建一个新的待办事项，并返回其详细信息")
  TodoVO createTodo(TodoCreateDTO dto);
}
