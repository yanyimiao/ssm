package com.controller;

import com.alibaba.fastjson.JSON;
import com.entity.DailyEntity;
import com.entity.DailyEntityQueryInfo;
import com.service.DailyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DailyController {
    @Resource
    DailyService dailyService;

    @RequestMapping("/or")
    @ResponseBody
    public Object query(String name){
        DailyEntityQueryInfo dailyEntityQueryInfo = new DailyEntityQueryInfo();
        List<DailyEntity> list = dailyService.query(dailyEntityQueryInfo);
        return JSON.parseArray(JSON.toJSONString(list));
    }
    @RequestMapping("/other/{id}")
    @ResponseBody
    public Object query(@PathVariable Integer id){
        DailyEntityQueryInfo dailyEntityQueryInfo = new DailyEntityQueryInfo();
        List<DailyEntity> list = dailyService.query(dailyEntityQueryInfo);
        return JSON.parseArray(JSON.toJSONString(list));
    }
}
