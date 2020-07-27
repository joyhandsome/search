package com.wang.search.service.impl;

import com.wang.search.core.DocumentEntity;
import com.wang.search.service.BaseSearchManage;
import com.wang.search.service.DocumentRepository;
import com.wang.search.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * search管理实现类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/14 19:25
 * @since JDK 1.8
 */
@Service
@Slf4j
public class BaseSearchManageImpl implements BaseSearchManage {
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Resource
    private DocumentRepository documentRepository;

    @Override
    public <T> void save(DocumentEntity t) {
        documentRepository.save(t);
    }

    @Override
    public String query(QueryBuilder queryBuilder) {
        Query query = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        return query.getHighlightQuery().toString();
    }

    @Override
    public String query(GeoDistanceSortBuilder sortBuilder) {
        return null;
    }

    @Override
    public String query(GeoDistanceAggregationBuilder aggregationBuilder) {
        return null;
    }

    @Override
    public String query() {
        Iterable<DocumentEntity> iterable = documentRepository.findAll();
        List<DocumentEntity> list = new ArrayList<>();
        iterable.forEach(list::add);
        list.forEach(System.out::println);
        return JsonUtil.data2Json(list);
    }
}
