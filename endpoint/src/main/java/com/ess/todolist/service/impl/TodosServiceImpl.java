package com.ess.todolist.service.impl;

import com.ess.todolist.exception.BusinessException;
import com.ess.todolist.custom.Err;
import com.ess.todolist.custom.TaskStatus;

import com.ess.todolist.entity.Todos;
import com.ess.todolist.vo.TodosVO;
import com.ess.todolist.dto.TodosCreateDTO;
import com.ess.todolist.service.TodosService;
import com.ess.todolist.mapper.TodosMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;

import java.time.LocalDateTime;

@Service
@Transactional
public class TodosServiceImpl implements TodosService {

  @Resource
  private TodosMapper todoMapper;

  // TODO(Ess): Refine error types
  @Override
  public TodosVO createTodo(TodosCreateDTO dto) {
    var todo = new Todos();
    BeanUtils.copyProperties(dto, todo);

    LocalDateTime now = LocalDateTime.now();
    todo.setCreatedAt(now);
    todo.setUpdatedAt(now);
    todo.setIsDeleted(false);
    todo.setStatus(TaskStatus.NOT_COMPLETED);

    try {
      todoMapper.insert(todo);
    } catch (Exception e) {
      throw new BusinessException(Err.DATABASE_ERROR.getCode(), "Database error occured while storing the todo task.",
          e);
    }

    TodosVO vo = new TodosVO();
    BeanUtils.copyProperties(todo, vo);
    return vo;
  }
}
