package com.zjt.manager.pojo.result;

public class SourceData {

    private String school;

    private Integer count;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SourceData{" +
                "school='" + school + '\'' +
                ", count=" + count +
                '}';
    }
}
