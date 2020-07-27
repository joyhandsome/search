package com.wang.search.core;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "document", createIndex = false, useServerConfiguration = true)
@Accessors(chain = true)
public class DocumentEntity implements Serializable {
    private static final long serialVersionUID = 1751743958756202884L;
    /**
     * 文档ID
     */
    @Id
    private int id;
    /**
     * 文档名称
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    /**
     * 内容
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;
    /**
     * 创建时间
     */
    @Field(type = FieldType.Date,analyzer = "ik_max_word")
    private Date createTime;
    /**
     * 更新时间
     */
    @Field(type = FieldType.Date,analyzer = "ik_max_word")
    private Date updateTime;
    /**
     * 文件链接
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String docPath;
}
