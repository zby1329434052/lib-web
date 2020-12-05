package com.zhang.libweb.service.impl;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.enums.HttpCode;
import com.zhang.libweb.mapper.book.BookClassMapper;
import com.zhang.libweb.model.BookClassDTO;
import com.zhang.libweb.service.BookClassService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class BookClassServiceImpl implements BookClassService {

    @Autowired
    private BookClassMapper bookClassMapper;

    @Override
    public ResultDTO findListByName(String name) {
        //非空判断
        if(StringUtils.isEmpty(name)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"搜索关键字不能为空");
        }
        //业务查找
        List<BookClassDTO> list = bookClassMapper.findListByName(name);
        if(CollectionUtils.isEmpty(list)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无对应分类信息");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"查找成功",list);
    }

    @Override
    public ResultDTO deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultDTO insert(BookClassDTO record) {
        return null;
    }

    @Override
    public ResultDTO insertSelective(BookClassDTO record) {
        return null;
    }

    @Override
    public ResultDTO selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public ResultDTO updateByPrimaryKeySelective(BookClassDTO record) {
        return null;
    }

    @Override
    public ResultDTO updateByPrimaryKey(BookClassDTO record) {
        return null;
    }
}
