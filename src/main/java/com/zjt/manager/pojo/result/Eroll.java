package com.zjt.manager.pojo.result;

import java.util.Date;

public class Eroll {

    private String eddate;

    private Integer count;

    public String getEddate() {
        return eddate;
    }

    public void setEddate(String eddate) {
        this.eddate = eddate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Eroll{" +
                "eddate='" + eddate + '\'' +
                ", count=" + count +
                '}';
    }
}
