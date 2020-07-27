package com.wang.search.service;

import com.wang.search.core.DocumentEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * elasticsearch api
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/27 16:25
 * @since JDK 1.8
 */
public interface DocumentRepository extends ElasticsearchRepository<DocumentEntity, Integer> {

}
