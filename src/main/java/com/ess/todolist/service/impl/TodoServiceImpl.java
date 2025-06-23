package com.ess.todolist.service.impl;

import com.ess.todolist.exception.BusinessException;
import com.ess.todolist.custom.Error;

import com.ess.todolist.entity.Todo;
import com.ess.todolist.vo.TodoVO;
import com.ess.todolist.dto.TodoCreateDTO;
import com.ess.todolist.service.TodoService;
import com.ess.todolist.mapper.TodoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.ApiOperation;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoMapper todoMapper;

  @Override
  @ApiOperation(value = "创建待办事项", notes = "根据提供的待办事项数据创建一个新的待办事项，并返回其详细信息")
  public TodoVO createTodo(TodoCreateDTO dto) {
    Todo todo = new Todo();
    BeanUtils.copyProperties(dto, todo);

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
