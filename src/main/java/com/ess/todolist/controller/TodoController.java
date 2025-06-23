package com.ess.todolist.controller;

import com.ess.todolist.custom.ApiResult;
import com.ess.todolist.service.TodoService;
import com.ess.todolist.vo.TodoVO;
import com.ess.todolist.dto.TodoCreateDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.*;

import jakarta.validation.Valid;

@Tag(name = "待办事项清单", description = "管理待办事项的相关接口")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

  @Autowired
  private TodoService todoService;

  @Operation(summary = "创建待办事项", description = "通过提供待办事项的基本信息来创建一个新的待办事项")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "待办事项创建成功"),
      @ApiResponse(responseCode = "400", description = "请求参数验证失败"),
      @ApiResponse(responseCode = "422", description = "业务异常导致的请求无法处理"),
      @ApiResponse(responseCode = "500", description = "服务器内部错误")
  })
  @PostMapping
  public ApiResult<TodoVO> create(
      @Parameter(description = "待办事项实体，包含标题、分类代码、优先级等信息", example = "{\"title\": \"买菜\", \"categoryCode\": \"General\", \"description\": \"购买新鲜蔬菜\", \"priority\": \"HIGH\", \"createdBy\": 1001}") @RequestBody @Valid TodoCreateDTO dto) {
    TodoVO vo = todoService.createTodo(dto);

    ApiResult<TodoVO> result = new ApiResult<>();
    result.setStatusCode(HttpStatus.CREATED.value());
    result.setData(vo);

    return result;
  }
}
