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
@Order(2)
public class SecondInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key2", "value2");
        MapPropertySource propertySource = new MapPropertySource("SecondInitializer", map);
        environment.getPropertySources().addLast(propertySource);
        System.out.println("SecondInitializer");
    }
}
