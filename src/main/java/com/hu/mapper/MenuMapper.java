package com.hu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hu.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userid);
}
