package com.zhang.libweb.service.impl;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.enums.HttpCode;
import com.zhang.libweb.mapper.book.BookClassMapper;
import com.zhang.libweb.model.book.BookClassDTO;
import com.zhang.libweb.service.BookClassService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class BookClassServiceImpl implements BookClassService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookClassMapper bookClassMapper;

    @Override
    public ResultDTO findListByName(String name) {
        logger.info("入参："+name);
        //非空判断
        if(StringUtils.isEmpty(name)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"搜索关键字不能为空");
        }
        //业务查找
        List<BookClassDTO> list = bookClassMapper.findListByName(name);
        logger.info("出参："+list);
        if(CollectionUtils.isEmpty(list)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无对应分类信息");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"查找成功",list);
    }

    @Override
    public ResultDTO deleteByPrimaryKey(Integer id) {
        logger.info("入参："+id);
        if(0 == id){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        int influenceNumber = bookClassMapper.deleteByPrimaryKey(id);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"删除失败");
        }

        return new ResultDTO(HttpCode.SUCCESS.getCode(),"删除成功");

    }

    @Override
    public ResultDTO insert(BookClassDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(record.getName())){
            return new ResultDTO(HttpCode.FAIL.getCode(),"分类名称不能为空");
        }
        int influenceNumber = bookClassMapper.insert(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"新增失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"新增成功");
    }

    @Override
    public ResultDTO insertSelective(BookClassDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(record.getName())){
            return new ResultDTO(HttpCode.FAIL.getCode(),"分类名称不能为空");
        }
        int influenceNumber = bookClassMapper.insert(record);
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
        BookClassDTO bookClassDTO = bookClassMapper.selectByPrimaryKey(id);
        logger.info("出参："+bookClassDTO);
        if (null == bookClassDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(),"暂无分类数据");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"查找成功",bookClassDTO);
    }

    @Override
    public ResultDTO updateByPrimaryKeySelective(BookClassDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(String.valueOf(record.getId()))){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        int influenceNumber = bookClassMapper.updateByPrimaryKey(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"更新失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"更新成功");
    }

    @Override
    public ResultDTO updateByPrimaryKey(BookClassDTO record) {
        logger.info("入参："+record);
        if(StringUtils.isEmpty(String.valueOf(record.getId()))){
            return new ResultDTO(HttpCode.FAIL.getCode(),"数据ID不能为空");
        }
        int influenceNumber = bookClassMapper.updateByPrimaryKey(record);
        if(influenceNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"更新失败");
        }
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"更新成功");
    }
}
