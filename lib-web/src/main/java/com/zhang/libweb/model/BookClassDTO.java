package com.zhang.libweb.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * book_class
 * @author 
 */
@Data
public class BookClassDTO implements Serializable {

    /**
     * 分类名称
     */
    private String name;

    private static final long serialVersionUID = 2L;
}