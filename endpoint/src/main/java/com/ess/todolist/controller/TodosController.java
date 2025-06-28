package com.ess.todolist.controller;

import com.ess.todolist.custom.ApiResult;
import com.ess.todolist.service.TodosService;
import com.ess.todolist.vo.TodosVO;
import com.ess.todolist.dto.TodosCreateDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodosController {

  @Resource
  private TodosService todoService;

  // MARK: 添加
  @PostMapping
  public ApiResult<TodosVO> create(
      @RequestBody @Valid TodosCreateDTO dto) {
    System.out.println(dto);
    TodosVO vo = todoService.createTodo(dto);

    ApiResult<TodosVO> result = new ApiResult<>();
    result.setStatusCode(HttpStatus.CREATED.value());
    result.setData(vo);

    return result;
  }

  // TODO(Ess): 通过 task_id 获取 todo 列表
  @GetMapping
  public ApiResult<TodosVO> getByTaskId(@RequestParam int task_id) {
    // TodoVO vo = todoService.createTodo(dto);

    ApiResult<TodosVO> result = new ApiResult<>();
    // result.setStatusCode(HttpStatus.CREATED.value());
    // result.setData(vo);

    return result;
  }

}
