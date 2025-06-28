package com.ess.todolist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ess.todolist.entity.Todos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodosMapper extends BaseMapper<Todos> {
  // 无需自定义方法
}
