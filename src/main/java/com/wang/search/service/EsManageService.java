package com.wang.search.service;

import com.wang.search.core.DocumentEntity;

import java.io.IOException;

/**
 * es
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/29 14:22
 * @since JDK 1.8
 */
public interface EsManageService {
    String search() throws IOException;
    void add(DocumentEntity documentEntity);
}
