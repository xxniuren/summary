package com.xxniuren.springboot.systemloader;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/19
 * @description:
 **/
@Order(1)
public class FirstInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        MapPropertySource propertySource = new MapPropertySource("FirstInitializer", map);
        environment.getPropertySources().addLast(propertySource);
        System.out.println("FirstInitializer");
    }
}
