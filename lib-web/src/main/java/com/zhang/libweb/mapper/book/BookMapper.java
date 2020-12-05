package com.zhang.libweb.mapper.book;


import com.zhang.libweb.model.book.BookDTO;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookDTO record);

    int insertSelective(BookDTO record);

    BookDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookDTO record);

    int updateByPrimaryKey(BookDTO record);
}