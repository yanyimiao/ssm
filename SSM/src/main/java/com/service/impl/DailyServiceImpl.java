package com.service.impl;

import com.dao.DailyMapper;
import com.entity.DailyEntity;
import com.entity.DailyEntityQueryInfo;
import com.service.DailyService;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("dailyService")
public class DailyServiceImpl implements DailyService {

    @Resource
    private DailyMapper dailyMapper;

    public List<DailyEntity> query(DailyEntityQueryInfo dailyEntityQueryInfo) {
        return dailyMapper.query(dailyEntityQueryInfo);
    }
    public int updateDaily(DailyEntity dailyEntity) {
        return dailyMapper.updateDaily(dailyEntity);
    }
    public int insertDaily(DailyEntity dailyEntity) {
        return dailyMapper.insertDaily(dailyEntity);
    }
    public int deleteDaily(String id) {
        return dailyMapper.deleteDaily(id);
    }

    public void insertTransTest(List<DailyEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            if(i==0){
                dailyMapper.insertDaily(list.get(i));
            }
//            else if(i==2){
//                int i1 = 1/0;
//            }
            else{
                dailyMapper.updateDaily(list.get(i));
            }
        }
    }


}
