package com.ess.todolist.service.impl;

import com.ess.todolist.exception.*;
import com.ess.todolist.custom.Err;

import com.ess.todolist.service.CategoriesService;
import com.ess.todolist.vo.CategoriesCommonVO;
import com.ess.todolist.mapper.CategoriesMapper;
import com.ess.todolist.entity.TaskCategories;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import jakarta.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

  @Resource
  private CategoriesMapper ctMapper;

  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  // MARK: get
  public ArrayList<CategoriesCommonVO> getAllCategories(Integer userId) {
    List<TaskCategories> rows = new ArrayList<>();

    QueryWrapper<TaskCategories> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("created_by", userId).or().eq("is_public", 1);

    // 过滤掉删除了的元素
    queryWrapper.eq("is_deleted", 0);

    try {
      String sql = queryWrapper.getSqlSegment();
      log.debug("Generated SQL: {}", sql);
      rows = ctMapper.selectList(queryWrapper);
    } catch (Exception e) {
      throw new BusinessException(Err.INTERNAL_ERROR.getCode(), "Failed to fetch categories", e);
    }

    var vos = new ArrayList<CategoriesCommonVO>();

    for (TaskCategories row : rows) {
      CategoriesCommonVO vo = new CategoriesCommonVO();
      BeanUtils.copyProperties(row, vo);
      vos.add(vo);
    }
    BeanUtils.copyProperties(rows, vos);

    return vos;
  }
}
