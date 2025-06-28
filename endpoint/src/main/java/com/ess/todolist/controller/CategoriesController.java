package com.ess.todolist.controller;

import java.util.List;

import com.ess.todolist.custom.ApiResult;
import com.ess.todolist.custom.Err;
import com.ess.todolist.dto.CategoriesCreateDTO;
import com.ess.todolist.vo.CategoriesCommonVO;
import com.ess.todolist.service.CategoriesService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoriesController {

  @Resource
  private CategoriesService service;

  // TODO: 添加类别
  // @PostMapping
  // public ApiResult<CategoriesCommonVO> create(
  // @RequestBody @Valid CategoriesCreateDTO dto) {
  // System.out.println(dto);
  // CategoriesCommonVO vo = service.createCategory(dto);
  //
  // ApiResult<CategoriesCommonVO> result = new ApiResult<>();
  // result.setStatusCode(HttpStatus.CREATED.value());
  // }

  // MARK: 获取所有类别
  @GetMapping("/users/{userId}/categories")
  public ApiResult<List<CategoriesCommonVO>> getAll(@PathVariable Integer userId) {
    List<CategoriesCommonVO> vos = service.getAllCategories(userId);

    ApiResult<List<CategoriesCommonVO>> result = new ApiResult<>();
    result.setStatusCode(HttpStatus.OK.value());
    result.setData(vos);

    return result;
  }

}
