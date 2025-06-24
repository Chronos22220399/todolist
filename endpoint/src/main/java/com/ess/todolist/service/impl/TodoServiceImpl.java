package com.ess.todolist.service.impl;

import com.ess.todolist.exception.BusinessException;
import com.ess.todolist.custom.Error;
import com.ess.todolist.custom.TaskStatus;

import com.ess.todolist.entity.Todo;
import com.ess.todolist.vo.TodoVO;
import com.ess.todolist.dto.TodoCreateDTO;
import com.ess.todolist.service.TodoService;
import com.ess.todolist.mapper.TodoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoMapper todoMapper;

  @Override
  public TodoVO createTodo(TodoCreateDTO dto) {
    Todo todo = new Todo();
    BeanUtils.copyProperties(dto, todo);

    LocalDateTime now = LocalDateTime.now();
    todo.setCreatedAt(now);
    todo.setUpdatedAt(now);
    todo.setStatus(TaskStatus.NOT_COMPLETED);

    try {
      todoMapper.insert(todo);
    } catch (Exception e) {
      throw new BusinessException(Error.USER_EXISTS.getCode(), e.getMessage());
    }

    TodoVO vo = new TodoVO();
    BeanUtils.copyProperties(todo, vo);
    return vo;
  }
}
