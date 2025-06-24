package com.ess.todolist.service;

import com.ess.todolist.dto.TodoCreateDTO;
import com.ess.todolist.vo.TodoVO;

public interface TodoService {

  TodoVO createTodo(TodoCreateDTO dto);
}
