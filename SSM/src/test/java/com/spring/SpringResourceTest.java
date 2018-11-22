package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class SpringResourceTest {

    public void resourceTest(){
        ApplicationContext cfx = new ClassPathXmlApplicationContext();
        Resource resource = cfx.getResource("resource/test.json");
        resource.getFilename();
    }
}
