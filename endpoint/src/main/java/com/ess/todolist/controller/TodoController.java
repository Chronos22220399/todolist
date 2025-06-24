package com.ess.todolist.controller;

import com.ess.todolist.custom.ApiResult;
import com.ess.todolist.service.TodoService;
import com.ess.todolist.vo.TodoVO;
import com.ess.todolist.dto.TodoCreateDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

  @Resource
  private TodoService todoService;

  // MARK: 添加
  @PostMapping
  public ApiResult<TodoVO> create(
      @RequestBody @Valid TodoCreateDTO dto) {
    System.out.println(dto);
    TodoVO vo = todoService.createTodo(dto);

    ApiResult<TodoVO> result = new ApiResult<>();
    result.setStatusCode(HttpStatus.CREATED.value());
    result.setData(vo);

    return result;
  }

  // MARK: 通过 task_id 获取 todo 列表
  @GetMapping
  public ApiResult<TodoVO> getByTaskId(@RequestParam int task_id) {
    // TodoVO vo = todoService.createTodo(dto);

    ApiResult<TodoVO> result = new ApiResult<>();
    // result.setStatusCode(HttpStatus.CREATED.value());
    // result.setData(vo);

    return result;
  }

}
