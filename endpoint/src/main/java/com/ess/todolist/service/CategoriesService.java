package com.ess.todolist.service;

import com.ess.todolist.dto.CategoriesCreateDTO;
import com.ess.todolist.vo.CategoriesCommonVO;

import java.util.List;

public interface CategoriesService {
  // MARK: 获取所有种类
  public List<CategoriesCommonVO> getAllCategories(Integer userId);

}
