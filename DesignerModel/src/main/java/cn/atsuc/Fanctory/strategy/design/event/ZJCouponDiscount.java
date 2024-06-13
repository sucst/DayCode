package cn.atsuc.Fanctory.strategy.design.event;

import cn.atsuc.Fanctory.strategy.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author csup
 * @creatTime 2024/5/27 12:27
 * @description
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {
    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
