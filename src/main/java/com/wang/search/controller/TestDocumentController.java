package com.wang.search.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/search")
    public String search() {

        return "ok";
    }
}
