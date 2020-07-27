package com.wang.search.controller;

import com.wang.search.core.DocumentEntity;
import com.wang.search.service.BaseSearchManage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 测试controller
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/14 19:35
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/doc")
public class TestDocumentController {

    @Resource
    private BaseSearchManage baseSearchManage;

    @RequestMapping("/save")
    public String test() {
        DocumentEntity documentEntity = new DocumentEntity().setContent("test content").setId(1234556).setTitle("test title").setUpdateTime(new Date());
        baseSearchManage.save(documentEntity);
        return "ok";
    }

    @RequestMapping("/search")
    public String search() {
       return baseSearchManage.query();
    }
}
