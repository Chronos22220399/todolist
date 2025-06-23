package com.ess.todolist.controller;

import com.ess.todolist.custom.ApiResult;
import com.ess.todolist.service.TodoService;
import com.ess.todolist.vo.TodoVO;
import com.ess.todolist.dto.TodoCreateDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.Resource;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

  @Resource
  private TodoService todoService;

  @PostMapping
  @ApiOperation(value = "创建待办事项", notes = "通过提供待办事项的基本信息来创建一个新的待办事项")
  @ApiResponses({
      @ApiResponse(code = 201, message = "待办事项创建成功"),
      @ApiResponse(code = 400, message = "请求参数验证失败"),
      @ApiResponse(code = 422, message = "业务异常导致的请求无法处理"),
      @ApiResponse(code = 500, message = "服务器内部错误")
  })
  public ApiResult<TodoVO> create(
      @ApiParam(value = "待办事项实体，包含标题、分类代码、优先级等信息", example = "{\"title\": \"买菜\", \"categoryCode\": \"General\", \"description\": \"购买新鲜蔬菜\", \"priority\": \"HIGH\", \"createdBy\": 1001}") @RequestBody @Valid TodoCreateDTO dto) {
    TodoVO vo = todoService.createTodo(dto);

    ApiResult<TodoVO> result = new ApiResult<>();
    result.setStatusCode(HttpStatus.CREATED.value());
    result.setData(vo);

    return result;
  }
}
