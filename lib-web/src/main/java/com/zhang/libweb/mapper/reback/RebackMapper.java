package com.zhang.libweb.mapper.reback;

import com.zhang.libweb.model.borrow.BookBorrowDTO;

public interface RebackMapper {

    /**
     *更新借书信息
     * @param bookBorrowDTO
     * @return
     */
    int updateBorrowInfo(BookBorrowDTO bookBorrowDTO);
}
