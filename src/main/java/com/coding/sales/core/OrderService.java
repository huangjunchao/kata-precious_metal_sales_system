package com.coding.sales.core;

import com.coding.sales.bean.Goods;
import com.coding.sales.bean.User;
import com.coding.sales.discount.DiscountCalculateFactory;
import com.coding.sales.discount.DiscountType;
import com.coding.sales.discount.IDiscountCalculate;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.core.*;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author huangjunchao
 * @Date 2019/7/2 18:19
 * @email 18234105447@163.com
 **/
public class OrderService {

    private OrderCommand orderCommand;

    private List<OrderItemRepresentation> orderItemRepresentationList = new ArrayList<OrderItemRepresentation>();

    private List<DiscountItemRepresentation> discountItemRepresentationList = new ArrayList<DiscountItemRepresentation>();

    private float totalDiscountPrice;

    private User user;

    private String oldMemberType;

    private int oldPoints;

    private float totalPrice;

    private float totalAfterDiscountPrice;

    public OrderService(OrderCommand orderCommand) {
        this.orderCommand = orderCommand;
        user = UserCenter.getUser(orderCommand.getMemberId());
        oldPoints = user.getPoints();
        oldMemberType = user.getGrade();
        initUserDiscountInfo();
    }

    public void  order() {
        List<OrderItemCommand> goodsList = orderCommand.getItems();
        for (OrderItemCommand orderItemCommand : goodsList) {
            Goods goods = GoodsCenter.getGoods(orderItemCommand.getProduct());
            long num = orderItemCommand.getAmount().longValue();
            List<Float> prices = calculateGoodsPrices(goods, num);
            float maxPrice = goods.getPrice() * num;
            float minPrice = Collections.min(prices);
            totalAfterDiscountPrice += minPrice;
            totalPrice += maxPrice;

            OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(goods.getId(),
                    goods.getName(),
                    float2BigDecimal(goods.getPrice()),
                    orderItemCommand.getAmount(),
                    float2BigDecimal(maxPrice));
            orderItemRepresentationList.add(orderItemRepresentation);

            float discountPrice = maxPrice - minPrice;
            if (discountPrice != 0) {
                DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(
                        goods.getId(), goods.getName(), float2BigDecimal(discountPrice));
                discountItemRepresentationList.add(discountItemRepresentation);
                totalDiscountPrice += discountPrice;
            }
        }
        user.addPoints(Float.valueOf(totalAfterDiscountPrice).longValue());
    }

    private List<Float> calculateGoodsPrices(Goods goods, long num) {
        List<Float> prices = new ArrayList<Float>();
        // 计算所有优惠方案的价格，选择一个优惠最大的
        for (DiscountType discount : goods.getDiscounts()) {
            if (discount == DiscountType.Dicount_Type1 || discount == DiscountType.Dicount_Type2 ) {
                if (!isUserHasDiscountCoupon(user, discount)) {
                    discount = DiscountType.Dicount_None;
                }
            }

            IDiscountCalculate calculate = DiscountCalculateFactory.getDiscountCalculate(discount);
            float price = calculate.calculatePrice(goods.getPrice(), num);
            prices.add(price);
        }
        return prices;
    }

    private void initUserDiscountInfo() {
        List<String> discountList = orderCommand.getDiscounts();
        if (discountList != null && discountList.size() > 0) {
            String discount = discountList.get(0);
            if ("9折券".equals(discount)) {
                user.setDiscounts(new DiscountType[]{DiscountType.Dicount_Type1});
            } else if ("95折券".equals(discount)){
                user.setDiscounts(new DiscountType[]{DiscountType.Dicount_Type2});
            }
        }
    }

    private List<PaymentRepresentation> getPaymentRepresentation() {
        List<PaymentRepresentation> paymentRepresentationList = new ArrayList<PaymentRepresentation>();
        List<PaymentCommand> paymentCommandList = orderCommand.getPayments();
        for (PaymentCommand paymentCommand : paymentCommandList) {
            PaymentRepresentation paymentRepresentation = new PaymentRepresentation(paymentCommand.getType(), paymentCommand.getAmount());
            paymentRepresentationList.add(paymentRepresentation);
        }
        return paymentRepresentationList;
    }

    public OrderRepresentation getResult() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int increasePoints = user.getPoints() - oldPoints;
        return new OrderRepresentation(orderCommand.getOrderId(),
                format.parse(orderCommand.getCreateTime()),
                orderCommand.getMemberId(),
                user.getUsername(),
                oldMemberType,
                user.getGrade(),
                increasePoints,
                user.getPoints(),
                orderItemRepresentationList,
                float2BigDecimal(totalPrice),
                discountItemRepresentationList,
                float2BigDecimal(totalDiscountPrice),
                float2BigDecimal(totalAfterDiscountPrice),
                getPaymentRepresentation(),
                orderCommand.getDiscounts()
                );
    }

    private boolean isUserHasDiscountCoupon(User user, DiscountType discountType) {
        DiscountType[] discounts = user.getDiscounts();
        if (discounts == null || discounts.length == 0) {
            return  false;
        }

        for (DiscountType discount : discounts) {
            if (discount.equals(discountType)) {
                return  true;
            }
        }
        return false;
    }

    private BigDecimal float2BigDecimal(float num) {
        return BigDecimal.valueOf(num);
    }

}
