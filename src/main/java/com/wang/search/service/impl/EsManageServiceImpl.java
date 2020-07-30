package com.wang.search.service.impl;

import com.wang.search.service.EsManageService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * es实现类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/29 14:25
 * @since JDK 1.8
 */
@Service
@Slf4j
public class EsManageServiceImpl implements EsManageService {

    @Resource
    private RestHighLevelClient client;

    @Override
    public String search() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("content","test"));
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = response.getHits().getHits();
        for (SearchHit hit : searchHits) {
            System.out.println("id: " + hit.getId());
            System.out.println("index: " + hit.getIndex());
            Map<String, Object> map = hit.getSourceAsMap();
            System.out.println(map.get("title"));
        }
        client.close();
        return null;
    }
}
