package com.zjt.manager.pojo.result;

import java.util.Date;

public class Eroll {

    private String edate;

    private Integer count;

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
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
                "edate=" + edate +
                ", count=" + count +
                '}';
    }
}
