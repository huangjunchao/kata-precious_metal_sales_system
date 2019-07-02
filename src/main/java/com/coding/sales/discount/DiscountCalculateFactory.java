package com.coding.sales.discount;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 18:14
 * @email 18234105447@163.com
 **/
public class DiscountCalculateFactory {

    public static IDiscountCalculate getDiscountCalculate(DiscountType discountType) {
        if (DiscountType.Dicount_Type1.equals(discountType)) {
            return new DicountCalculateType1();
        }

        if (DiscountType.Dicount_Type2.equals(discountType)) {
            return new DicountCalculateType2();
        }

        if (DiscountType.Dicount_Type3.equals(discountType)) {
            return new DicountCalculateType3();
        }

        if (DiscountType.Dicount_Type4.equals(discountType)) {
            return new DicountCalculateType4();
        }

        if (DiscountType.Dicount_Type5.equals(discountType)) {
            return new DicountCalculateType5();
        }

        if (DiscountType.Dicount_Type6.equals(discountType)) {
            return new DicountCalculateType6();
        }

        if (DiscountType.Dicount_Type7.equals(discountType)) {
            return new DicountCalculateType7();
        }

        return new DicountCalculateType8();
    }
}
