package com.coding.sales.other;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class UserTest {

    private long points;
    private String grade;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][]{
                {1000, "普卡"},
                {10001, "金卡"},
                {60000, "白金卡"},
                {110000, "钻石卡"},
        };

        return Arrays.asList(data);
    }

    public UserTest(long points, String grade) {
        this.points =  points;
        this.grade = grade;
    }

    @Test
    public void getGrade() {
        User user = new User(points);
        assertEquals(grade, user.getGrade());
    }
}