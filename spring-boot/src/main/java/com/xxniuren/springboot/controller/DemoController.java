package com.xxniuren.springboot.controller;

import com.xxniuren.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/19
 * @description:
 **/
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    @ResponseBody
    public String test() {
        return testService.test();
    }

}
