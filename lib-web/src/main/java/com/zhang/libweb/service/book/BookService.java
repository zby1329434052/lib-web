package com.zhang.libweb.service.book;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.model.book.BookDTO;
import com.zhang.libweb.model.book.BookDTO;

import java.util.List;

public interface BookService {
    /**
     * 根据名称模糊查询全部书籍信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    ResultDTO findListByName(String name);

    /**
     * 删除
     * @param id 数据主键
     * @return
     */
    ResultDTO deleteByPrimaryKey(Integer id);

    /**
     * 新增
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO insert(BookDTO record);

    /**
     *     selective区别在 如果属性为空则对应属性不更新
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO insertSelective(BookDTO record);

    ResultDTO selectByPrimaryKey(int id);

    /**
     * selective更新
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO updateByPrimaryKeySelective(BookDTO record);

    /**
     * 更新
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO updateByPrimaryKey(BookDTO record);
}
