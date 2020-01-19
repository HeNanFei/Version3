package com.zjt.manager.pojo.search;

public class SearchCriteron {

    private int limit;

    private int page;

    private String projectName;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "SearchCriteron{" +
                "limit=" + limit +
                ", page=" + page +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
