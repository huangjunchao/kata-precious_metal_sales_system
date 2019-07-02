package com.coding.sales.core;

import com.coding.sales.bean.Goods;
import com.coding.sales.discount.DiscountType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 17:08
 * @email 18234105447@163.com
 **/
public class GoodsCenter {

    private static final Map<String, Goods> mGoods = new HashMap<String, Goods>() {{
        put("001001", new Goods("001001","世园会五十国钱币册", 998,
                new DiscountType[]{DiscountType.Dicount_None}));

        put("001002", new Goods("001002","2019北京世园会纪念银章大全40g", 1380,
                new DiscountType[]{DiscountType.Dicount_Type1}));

        put("003001", new Goods("003001","招财进宝", 1580,
                new DiscountType[]{DiscountType.Dicount_Type2}));

        put("003002", new Goods("003002","水晶之恋", 980,
                new DiscountType[]{DiscountType.Dicount_Type3, DiscountType.Dicount_Type4}));

        put("002002", new Goods("002002","中国经典钱币套装", 998,
                new DiscountType[]{DiscountType.Dicount_Type5, DiscountType.Dicount_Type6}));

        put("002001", new Goods("002001","守扩之羽比翼双飞4.8g", 1080,
                new DiscountType[]{DiscountType.Dicount_Type3, DiscountType.Dicount_Type4, DiscountType.Dicount_Type2}));

        put("002003", new Goods("002003","中国银象棋12g", 698,
                new DiscountType[]{DiscountType.Dicount_Type5, DiscountType.Dicount_Type6, DiscountType.Dicount_Type7, DiscountType.Dicount_Type1}));
    } };

    public static Goods getGoods(String goodsId){
        return  mGoods.get(goodsId);
    }
}
