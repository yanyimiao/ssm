package com.java;

import com.BaseTest;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class DbTest extends BaseTest {
    

    @Test
    public void test2(){
        Jedis jedis = new Jedis("127.0.0.1");
        String test = jedis.get("test:other");
        jedis.set("jedis","jedisValue");
        System.out.println(test);

    }
}
