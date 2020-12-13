package com.zhang.libweb.web.reback;


import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.enums.HttpCode;
import com.zhang.libweb.model.borrow.BookBorrowDTO;
import com.zhang.libweb.service.reback.RebackService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/reback")
public class RebackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RebackService rebackService;

    @RequestMapping("/doBack")
    public ResultDTO rebackBook(@RequestBody BookBorrowDTO bookBorrowDTO){
        try {
            return rebackService.updateBorrowInfo(bookBorrowDTO);
        } catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }
}
