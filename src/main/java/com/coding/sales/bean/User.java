package com.coding.sales.bean;

import com.coding.sales.discount.DiscountType;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 16:11
 * @email 18234105447@163.com
 **/
public class User {
    private String username;
    private String grade;
    private String memberId;
    private int points;
    private DiscountType[] discounts;

    public DiscountType[] getDiscounts() {
        return discounts;
    }

    public void setDiscounts(DiscountType[] discounts) {
        this.discounts = discounts;
    }

    public User(String username, String memberId, int points) {
        this.username = username;
        this.memberId = memberId;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long addPoints(long increasePoints) {
        if (points < 10000) {
            return points += increasePoints;
        }

        if (points >= 10000 && points < 50000) {
            return points += increasePoints * 1.5;
        }

        if (points >=50000 && points < 100000) {
            return points += increasePoints * 1.8;
        }
        return points += increasePoints * 2;
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
