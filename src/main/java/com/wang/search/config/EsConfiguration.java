//package com.wang.search.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * es配置bean类
// *
// * @author wangjunhao
// * @version 1.0
// * @date 2020/7/29 13:49
// * @since JDK 1.8
// */
//@Slf4j
//@Configuration
//public class EsConfiguration {
//    @Bean
//    public RestHighLevelClient getClient() {
//       return new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("localhost", 9200, "http")));
//    }
//}
