package com.wang.search.core;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 文档实体类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/6/6 11:56
 * @since JDK 1.8
 */
@Data
@Accessors(chain = true)
public class DocumentEntity implements Serializable {
    private static final long serialVersionUID = 1751743958756202884L;
    /**
     * 文档ID
     */
    private int id;
    /**
     * 文档名称
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 文件链接
     */
    private String docPath;
}
