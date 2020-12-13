package com.zhang.libweb.service.reback;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.model.borrow.BookBorrowDTO;

public interface RebackService {

    /**
     * 更新借书信息
     * @param bookBorrowDTO
     * @return
     */
    ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO);

}
