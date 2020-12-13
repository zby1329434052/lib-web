package com.zhang.libweb.service.book.impl;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.enums.HttpCode;
import com.zhang.libweb.mapper.book.BookMapper;
import com.zhang.libweb.model.book.BookDTO;
import com.zhang.libweb.service.book.BookService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;


    @Override
    public ResultDTO findListByName(String name) {
        logger.info("入参："+name);
        //非空判断
        if(StringUtils.isEmpty(name)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"搜索关键字不能为空");
        }
        //业务查找
        List<BookDTO> list = bookMapper.findListByName(name);
        logger.info("出参："+list);
        if(CollectionUtils.isEmpty(list)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无对应书籍信息");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"查找成功",list);
    }

    @Override
    public ResultDTO deleteByPrimaryKey(Integer id) {
        logger.info("入参："+id);
        if(0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        int influenceNumber = bookMapper.deleteByPrimaryKey(id);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"删除失败");
        }

        return new ResultDTO(HttpCode.SUCCESS.getCode(),"删除成功");

    }

    @Override
    public ResultDTO insert(BookDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(record.getBookName())){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍名称不能为空");
        }
        if(StringUtils.isEmpty(String.valueOf(record.getBookClassId()))){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍分类编号不能为空");
        }
        int influenceNumber = bookMapper.insert(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"新增失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"新增成功");
    }

    @Override
    public ResultDTO insertSelective(BookDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(record.getBookName())){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍名称不能为空");
        }
        if(StringUtils.isEmpty(String.valueOf(record.getBookClassId()))){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍分类编号不能为空");
        }
        if(0 >= record.getBookCount()){
            return new ResultDTO(HttpCode.FAIL.getCode(),"书籍数量不能小于零");
        }
        int influenceNumber = bookMapper.insertSelective(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"新增失败");
        }

        return new ResultDTO(HttpCode.SUCCESS.getCode(),"新增成功");
    }

    @Override
    public ResultDTO selectByPrimaryKey(int id) {
        logger.info("入参："+id);
        if(0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        //业务查找
        BookDTO BookDTO = bookMapper.selectByPrimaryKey(id);
        logger.info("出参："+BookDTO);
        if (null == BookDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无书籍数据");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"查找成功",BookDTO);
    }

    @Override
    public ResultDTO updateByPrimaryKeySelective(BookDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(String.valueOf(record.getId()))){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        int influenceNumber = bookMapper.updateByPrimaryKeySelective(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"更新失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"更新成功");
    }

    @Override
    public ResultDTO updateByPrimaryKey(BookDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(String.valueOf(record.getId()))){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        int influenceNumber = bookMapper.updateByPrimaryKey(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"更新失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"更新成功");
    }
}
