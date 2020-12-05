package com.zhang.libweb.model;

import lombok.Data;
import java.util.Date;

@Data
public class BaseDTO {
    /**
     * 数据主键
     */
    private Integer id;

    /**
     * 临时字段1
     */
    private String tmp1;

    /**
     * 临时字段2
     */
    private String tmp2;

    /**
     * 入库时间
     */
    private Date createDate;

    /**
     * 最近一次更新时间
     */
    private Date updateDate;

    /**
     * 标识数据有效性(ENABLE有效数据DISABLE无效数据)
     */
    private String validFlagEnum;
}
