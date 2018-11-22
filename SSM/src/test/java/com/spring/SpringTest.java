package com.spring;

import com.BaseTest;
import com.alibaba.fastjson.JSON;
import com.dao.JdbcDao;
import com.entity.DailyEntity;
import com.entity.DailyEntityQueryInfo;
import com.service.DailyService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class SpringTest extends BaseTest {
    @Resource
    private DailyService dailyService;
    @Resource
    private JdbcDao jdbcDao;

    @Test
    public void jdbcTest(){
        List<DailyEntity> list = jdbcDao.select();
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void queryTest(){
       List<DailyEntity> list = dailyService.query(new DailyEntityQueryInfo());
       System.out.println(JSON.toJSONString(list));
    }


    @Test
    public void insertTest(){
        DailyEntity dailyEntity = new DailyEntity();
        dailyEntity.setGender("female");
        dailyEntity.setName("still test");
        int result= dailyService.insertDaily(dailyEntity);
        System.out.println(result);
    }

    @Test
    public void updateTest(){
        DailyEntity dailyEntity = new DailyEntity();
        dailyEntity.setGender("male");
        dailyEntity.setId("2");
        dailyEntity.setName("宋教仁");
        int result = dailyService.updateDaily(dailyEntity);
        System.out.println("结果： "+ result);
    }

    @Test
    public void deleteDailyTest(){
        int result = dailyService.deleteDaily("6");
        System.out.println(result);
    }

    /**
     * 测试申明式事务回滚
     */
    @Test
    public void transactionTest(){
        List<DailyEntity> list = new ArrayList<DailyEntity>(2);
        list.add(new DailyEntity("4","male","transactionTest"));
        list.add(new DailyEntity("5","female","我是谁"));
        list.add(new DailyEntity("6","female","我是谁"));
        dailyService.insertTransTest(list);
    }

}
