package com.wang.search.controller;

import com.wang.search.service.EsManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

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
    private EsManageService esManageService;

    @RequestMapping("/search")
    public String search() throws IOException {
        esManageService.search();
        return "ok";
    }

    @RequestMapping("/save")
    public String save() {
        return "ok";
    }
}
