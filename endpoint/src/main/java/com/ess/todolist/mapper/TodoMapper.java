package com.ess.todolist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ess.todolist.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper extends BaseMapper<Todo> {
  // 无需自定义方法
}
