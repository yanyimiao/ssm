package com.dao;

import com.entity.DailyEntity;
import com.entity.DailyEntityQueryInfo;

import java.util.List;

public interface DailyMapper {
    List<DailyEntity> query(DailyEntityQueryInfo dailyEntityQueryInfo);

    int updateDaily(DailyEntity dailyEntity);

    int insertDaily(DailyEntity dailyEntity);

    int deleteDaily(String id);
}
