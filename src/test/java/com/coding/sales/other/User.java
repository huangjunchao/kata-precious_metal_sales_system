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
    private BigDecimal points;
    public User(String username, String grade, String memberId, BigDecimal points) {
        this.username = username;
        this.grade = grade;
        this.memberId = memberId;
        this.points = points;
    }
    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGrade() {
        return grade;
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
