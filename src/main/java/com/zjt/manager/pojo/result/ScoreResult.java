package com.zjt.manager.pojo.result;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ScoreResult {
    private int cid;

    private int sid;

    private int tid;

    private int score;

    private String sname;

    private String lname;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date cdate;

    private int scoreid;

    private String  cname;

    private String ctname;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    @Override
    public String toString() {
        return "ScoreResult{" +
                "cid=" + cid +
                ", sid=" + sid +
                ", tid=" + tid +
                ", score=" + score +
                ", sname='" + sname + '\'' +
                ", lname='" + lname + '\'' +
                ", cdate=" + cdate +
                ", scoreid=" + scoreid +
                ", cname='" + cname + '\'' +
                ", ctname='" + ctname + '\'' +
                '}';
    }
}
