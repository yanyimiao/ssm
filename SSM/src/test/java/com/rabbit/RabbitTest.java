package com.rabbit;

import com.BaseTest;
import com.util.rabbit.RabbitMQ;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RabbitTest extends BaseTest {
    @Autowired
    private RabbitMQ rabbitMQ;

    @Test
    public void test(){
        String beanName = "mobileOfChina";
        String methodName = "mobileV3";
        Map<String,Object> param = new HashMap<String, Object>();
        List list=new ArrayList();
        list.add("TASKYYS100000201712081422290720980846");
        list.add(3);
        param.put("data", list);
        rabbitMQ.pushMessageToMq(beanName,methodName,param);
    }
}
