package com.service;

import com.entity.DailyEntity;
import com.entity.DailyEntityQueryInfo;

import java.util.List;

public interface DailyService {
    List<DailyEntity> query(DailyEntityQueryInfo dailyEntityQueryInfo);

    int updateDaily(DailyEntity dailyEntity);

    int insertDaily(DailyEntity dailyEntity);

    int deleteDaily(String id);

    void insertTransTest(List<DailyEntity> list);
}
