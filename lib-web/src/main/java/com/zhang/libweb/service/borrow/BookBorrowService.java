package com.zhang.libweb.service.borrow;

import com.zhang.libweb.constants.ResultDTO;
import com.zhang.libweb.model.borrow.BookBorrowDTO;

import java.util.Date;

public interface BookBorrowService {

    /**
     * 根据名称模糊查询全部信息
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
     * 新增借书信息
     * @param record 实体类（不好含ID）借书信息实体类
     * @return
     */
    ResultDTO insert(BookBorrowDTO record);

    /**
     *     selective区别在 如果属性为空则对应属性不更新
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO insertSelective(BookBorrowDTO record);

    ResultDTO selectByPrimaryKey(int id);

    /**
     * selective更新
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO updateByPrimaryKeySelective(BookBorrowDTO record);

    /**
     * 更新
     * @param record 实体类（不好含ID）
     * @return
     */
    ResultDTO updateByPrimaryKey(BookBorrowDTO record);

    ResultDTO doBookBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag);
}
