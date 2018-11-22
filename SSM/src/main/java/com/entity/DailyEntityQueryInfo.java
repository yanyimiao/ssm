package com.entity;

import com.alibaba.fastjson.JSONObject;

public class DailyEntityQueryInfo {
    private String id;
    private String name;
    private String gender;
    private String returnColumn;

    public DailyEntityQueryInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReturnColumn() {
        return returnColumn;
    }

    public void setReturnColumn(String returnColumn) {
        this.returnColumn = returnColumn;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
