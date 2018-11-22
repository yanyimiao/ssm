package com.dao.impl;


import com.dao.JdbcDao;
import com.entity.DailyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

public class JdbcDaoImpl implements JdbcDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<DailyEntity> select() {
        return jdbcTemplate.queryForList("select id,name,gender from test_table",DailyEntity.class);
    }
}
