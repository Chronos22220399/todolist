package com.ess.todolist.service;

import com.ess.todolist.dto.TodosCreateDTO;
import com.ess.todolist.vo.TodosVO;

public interface TodosService {

  TodosVO createTodo(TodosCreateDTO dto);
}
