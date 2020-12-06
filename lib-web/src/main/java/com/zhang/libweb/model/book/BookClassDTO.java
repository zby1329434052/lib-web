package com.zhang.libweb.model.book;

import java.io.Serializable;

import com.zhang.libweb.model.BaseDTO;
import lombok.Data;

/**
 * book_class
 * @author 
 */
@Data
public class BookClassDTO extends BaseDTO implements Serializable {

    /**
     * 分类名称
     */
    private String name;

    private static final long serialVersionUID = 2L;
}