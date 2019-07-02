package com.coding.sales.discount;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 17:44
 * @email 18234105447@163.com
 * 每满3000元减350
 **/
public class DicountCalculateType7 implements  IDiscountCalculate {
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
        float total = unitPrice * totalGoods;
        total -= ((int)(total / 3000)) * 350;
        return total;
    }
}
