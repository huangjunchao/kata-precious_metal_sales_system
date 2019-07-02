package com.coding.sales.bean;

import com.coding.sales.discount.DiscountType;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 16:11
 * @email 18234105447@163.com
 **/
public class Goods {
    private String id;
    private String name;
    private long price;
    private DiscountType[] discounts;

    public Goods(String id, String name, long price, DiscountType[] discounts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discounts = discounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public DiscountType[] getDiscounts() {
        return discounts;
    }

    public void setDiscounts(DiscountType[] discounts) {
        this.discounts = discounts;
    }
}
