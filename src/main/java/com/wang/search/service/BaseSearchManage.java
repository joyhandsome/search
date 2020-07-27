package com.wang.search.service;

import com.wang.search.core.DocumentEntity;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;

/**
 * 基础查询管理类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/14 18:54
 * @since JDK 1.8
 */
public interface BaseSearchManage {

    /**
     * 保存
     *
     * @return void
     * @date 2020/7/14 18:55
     * @author wangjunhao
     **/
    <T> void save(DocumentEntity t);

    String query(QueryBuilder queryBuilder);

    String query(GeoDistanceSortBuilder sortBuilder);

    String query(GeoDistanceAggregationBuilder aggregationBuilder);

    String query();
}
