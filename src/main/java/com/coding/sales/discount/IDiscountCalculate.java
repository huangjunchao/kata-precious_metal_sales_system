package com.coding.sales.discount;

public interface IDiscountCalculate {

    /**
     * @Author huangjunchao
     * @Description //TODO
     * @Date 2019/7/2 17:42
     * @Param [单价, 产品数量]
     * @return long
     **/
    float calculatePrice(float unitPrice, long totalGoods);
}
