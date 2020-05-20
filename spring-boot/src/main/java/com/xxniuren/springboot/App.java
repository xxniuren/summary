package com.xxniuren.springboot;

import com.xxniuren.springboot.systemloader.SecondInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/19
 * @description:
 *
 * todo: 实现一个自动启动类，然后引用，参考： https://www.bilibili.com/video/BV15J411C7aa?p=21
 **/
@SpringBootApplication
public class App {

    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.addInitializers(new SecondInitializer());
        springApplication.run(args);
    }

}
