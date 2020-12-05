package com.zhang.libweb.mapper;

import com.zhang.libweb.model.BookClassDTO;

public interface BookClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookClassDTO record);

    int insertSelective(BookClassDTO record);

    BookClassDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookClassDTO record);

    int updateByPrimaryKey(BookClassDTO record);
}