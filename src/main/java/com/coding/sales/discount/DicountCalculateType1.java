package com.coding.sales.discount;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 17:44
 * @email 18234105447@163.com
 * 九折优惠计算器
 **/
public class DicountCalculateType1 implements IDiscountCalculate {
    /**
     * @param unitPrice
     * @param totalGoods
     * @return long
     * @Author huangjunchao
     * @Description //TODO
     * @Date 2019/7/2 17:42
     * @Param [单价, 产品数量]
     */
    @Override
    public float calculatePrice(float unitPrice, long totalGoods) {
        return unitPrice * totalGoods * 0.9f;
    }
}
