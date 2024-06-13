package cn.atsuc.Fanctory.strategy.design.event;

import cn.atsuc.Fanctory.strategy.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author csup
 * @creatTime 2024/5/27 12:26
 * @description
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {
    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
