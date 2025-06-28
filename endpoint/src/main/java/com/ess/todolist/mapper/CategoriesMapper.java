package com.ess.todolist.mapper;

import com.ess.todolist.entity.TaskCategories;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface CategoriesMapper extends BaseMapper<TaskCategories> {

}
