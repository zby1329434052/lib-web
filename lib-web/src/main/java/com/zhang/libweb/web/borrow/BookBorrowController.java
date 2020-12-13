package com.zhang.libweb.web.borrow;


import com.alibaba.fastjson.JSONObject;
import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.enums.HttpCode;
import com.zhang.libweb.enums.ValidFlagEnum;
import com.zhang.libweb.mapper.book.BookMapper;
import com.zhang.libweb.model.book.BookDTO;
import com.zhang.libweb.model.borrow.BookBorrowDTO;
import com.zhang.libweb.service.borrow.BookBorrowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;


@RestController
@RequestMapping("/borrow")
public class BookBorrowController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookBorrowService bookBorrowService;

    /**
     * 借书操作
     * @param jsonObject
     * @return
     */
    @RequestMapping("/doBorrow")
    public ResultDTO doBorrow(@RequestBody JSONObject jsonObject){

        try {
            int bookId = Integer.parseInt(String.valueOf(jsonObject.getOrDefault("bookId",0)));
            Date startDate = jsonObject.getDate("startDate");
            Date endDate = jsonObject.getDate("endDate");
            int borrowCount = jsonObject.getInteger("borrowCount");
            int userId = jsonObject.getInteger("userId");
            String userName = jsonObject.getString("userName");
            boolean vipFlag = jsonObject.getBoolean("vipFlag");

            return bookBorrowService.doBookBorrow(bookId,startDate,endDate,borrowCount,userId,userName,vipFlag);
        } catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }
}
