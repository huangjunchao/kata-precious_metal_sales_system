package com.coding.sales.other;

import java.math.BigDecimal;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 16:11
 * @email 18234105447@163.com
 **/
public class User {
    private String username;
    private String grade;
    private String memberId;
    private long points;

    public User(String username, String memberId, long points) {
        this.username = username;
        this.memberId = memberId;
        this.points = points;
    }

    public User (long points){
        this.points = points;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGrade() {
        if (points < 10000) {
            return "普卡";
        }

        if (points >= 10000 && points < 50000) {
            return "金卡";
        }

        if (points >=50000 && points < 100000) {
            return "白金卡";
        }

        return "钻石卡";
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
