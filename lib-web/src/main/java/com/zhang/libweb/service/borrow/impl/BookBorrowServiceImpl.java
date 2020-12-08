package com.zhang.libweb.service.borrow.impl;

import com.zhang.libweb.mapper.borrow.BookBorrowMapper;
import com.zhang.libweb.service.borrow.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper bookBorrowMapper;


}
