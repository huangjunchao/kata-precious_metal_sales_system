package com.coding.sales.other;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 16:37
 * @email 18234105447@163.com
 **/
public class UserCenter {

    private static final Map<String, User> mUsers = new HashMap<String, User>() {{
        put("6236609999", new User("马丁","6236609999", 9860));
        put("6630009999", new User("王立","6630009999", 48860));
        put("8230009999", new User("李想","8230009999", 98860));
        put("9230009999", new User("张三","9230009999", 198860));
    } };

    public static User getUser(String memberId){
        return mUsers.get(memberId);
    }

}
