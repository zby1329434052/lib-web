package com.zhang.libweb.service.borrow.impl;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.enums.HttpCode;
import com.zhang.libweb.enums.ValidFlagEnum;
import com.zhang.libweb.mapper.book.BookMapper;
import com.zhang.libweb.mapper.borrow.BookBorrowMapper;
import com.zhang.libweb.model.book.BookDTO;
import com.zhang.libweb.model.borrow.BookBorrowDTO;
import com.zhang.libweb.service.borrow.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResultDTO findListByName(String name) {
        return null;
    }

    @Override
    public ResultDTO deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultDTO insert(BookBorrowDTO record) {
        return null;
    }

    @Override
    public ResultDTO insertSelective(BookBorrowDTO record) {
        return null;
    }

    @Override
    public ResultDTO selectByPrimaryKey(int id) {
        return null;
    }

    @Override
    public ResultDTO updateByPrimaryKeySelective(BookBorrowDTO record) {
        return null;
    }

    @Override
    public ResultDTO updateByPrimaryKey(BookBorrowDTO record) {
        return null;
    }

    @Override
    public ResultDTO doBookBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {

        //Step 1：非法校验
        if(0>=bookId){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍编号不合法，请确认所选择的书籍是否存在！");
        }
        //租赁起始截止日期(日期前后的非法校验交给前端来做)
        if(startDate.after(endDate)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"起始日期不能晚于归还日期！");
        }

        //Step 2:获取书籍
        BookDTO bookDTO = bookMapper.selectByPrimaryKey(bookId);
        //2.1 书籍存在性判断
        if (null == bookDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍不存在！");
        }
        //2.2 数量是否足够的校验
        int bookCount = bookDTO.getBookCount();
        if (bookCount <= 0){
            // TODO 在查找书籍的时候如果返回的书籍数量为0，前端直接进用租借按钮，同时加一个效果，当前书籍已租借光了
            return new ResultDTO(HttpCode.FAIL.getCode(),"当前书籍已经被借光了，请看看别的书吧！");
        }

        if (borrowCount> bookCount){
            return new ResultDTO(HttpCode.FAIL.getCode(),"借阅数量超过书籍存量，当前剩余数量："+bookCount);
        }

        //Step 3:真正的借书操作
        int result = doInsertBookBorrowRecord(bookId,bookDTO,borrowCount,userId,userName,startDate,endDate,vipFlag);

        if(result<=0){
            //新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(),"借书失败，您可以尝试重新借书，或联系图书管理员处理");
        }

        //Step 4:减少书籍数量
        bookDTO.setBookCount(bookCount - borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.updateByPrimaryKeySelective(bookDTO);
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"借书成功");
    }

    private int doInsertBookBorrowRecord(int bookId, BookDTO bookDTO, int borrowCount, int userId, String userName, Date startDate, Date endDate, boolean vipFlag){
        BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setBookName(bookDTO.getBookName());
        //也可以从session中获取
        bookBorrowDTO.setUserId(userId);
        bookBorrowDTO.setUserName(userName);
        //设置书籍价格
        BigDecimal bookPrice = bookDTO.getBookPrice();
        Long day = (endDate.getTime() - startDate.getTime())/(24*60*60*1000);
        long totalPrice = bookPrice.intValue() * day;

        bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));
        if (vipFlag){
            bookBorrowDTO.setTradeFee(new BigDecimal(0.0));
        }
        bookBorrowDTO.setCreateDate(new Date());
        bookBorrowDTO.setValidFlagEnum(String.valueOf(ValidFlagEnum.ENABLE));
        //新增
        int result = bookBorrowMapper.insert(bookBorrowDTO);
        return result;
    }
}
