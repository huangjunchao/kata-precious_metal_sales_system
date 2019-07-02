package com.coding.sales.core;

import com.coding.sales.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class UserTest {

    private int points;
    private String grade;
    private int addPoints;
    private int afterAddPoints;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][]{
                {1000, "普卡", 500, 1500},
                {20000, "金卡", 500, 20750},
                {60000, "白金卡", 500, 60900},
                {110000, "钻石卡", 500, 111000},
        };

        return Arrays.asList(data);
    }

    public UserTest(int points, String grade,int addPoints, int afterAddPoints) {
        this.points =  points;
        this.grade = grade;
        this.addPoints = addPoints;
        this.afterAddPoints = afterAddPoints;
    }

    @Test
    public void getGrade() {
        User user = new User(points);
        assertEquals(grade, user.getGrade());
    }
    @Test
    public void addPoints() {
        User user = new User(points);
        long increasePoints = user.addPoints(addPoints);
        assertEquals(afterAddPoints,increasePoints);
    }
}