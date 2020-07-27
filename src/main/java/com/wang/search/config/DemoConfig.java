//package com.wang.search.config;
//
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import com.wang.search.job.MyJob;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//
///**
// * 测试config
// *
// * @author wangjunhao
// * @version 1.0
// * @date 2020/6/17 13:58
// * @since JDK 1.8
// */
//@Configuration
//public class DemoConfig {
//    @Resource
//    private ZookeeperRegistryCenter zookeeperRegistryCenter;
//    @Resource
//    private ZookeeperConfig zookeeperConfig;
//
//    private static final String cron = "0/2 * * * * ? ";
//
//    @Bean(initMethod = "init")
//    public JobScheduler demoScheduler(final MyJob myJob) {
//        LiteJobConfiguration configuration = LiteJobConfiguration.newBuilder(
//                new SimpleJobConfiguration(
//                        JobCoreConfiguration.newBuilder(
//                                "first", zookeeperConfig.getJob().get("first"),
//                                zookeeperConfig.getTime().get("first")).build(),
//                        MyJob.class.getCanonicalName())).overwrite(true).build();
//
//        return new SpringJobScheduler(myJob, zookeeperRegistryCenter, configuration);
//    }
//}
