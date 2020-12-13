package com.zhang.libweb.model.borrow;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.zhang.libweb.model.BaseDTO;
import lombok.Data;

/**
 * book_borrow
 * @author 
 */
@Data
public class BookBorrowDTO extends BaseDTO implements Serializable {

//    /**
//     * 数据主键
//     */
//    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 书籍编号
     */
    private Integer bookId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍数量
     */
    private Integer count;

    /**
     * 开始借书时间
     */
    private Date startDate;

    /**
     * 结束借书时间
     */
    private Date endDate;

    /**
     * 借书价格
     */
    private BigDecimal price;

    /**
     * 实际成交价格
     */
    private BigDecimal tradeFee;

//    /**
//     * 备份字段1
//     */
//    private String tmp1;
//
//    /**
//     * 备份字段2
//     */
//    private String tmp2;
//
//    /**
//     * 创建时间
//     */
//    private Date createDate;
//
//    /**
//     * 最近一次更新时间
//     */
//    private Date updateDate;
//
//    /**
//     * 数据是否有效 有效ENABLE  无效DISABLE
//     */
//    private String validFlag;

    private static final long serialVersionUID = 1L;
}