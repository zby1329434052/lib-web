package com.zhang.libweb.mapper.borrow;

import com.zhang.libweb.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookBorrowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookBorrowDTO record);

    int insertSelective(BookBorrowDTO record);

    BookBorrowDTO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookBorrowDTO record);

    int updateByPrimaryKey(BookBorrowDTO record);
}