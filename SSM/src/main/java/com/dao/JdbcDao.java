package com.dao;

import com.entity.DailyEntity;

import java.util.List;

public interface JdbcDao {

    List<DailyEntity> select();
}
