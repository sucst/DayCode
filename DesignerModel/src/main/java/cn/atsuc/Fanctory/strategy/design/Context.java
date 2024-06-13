package cn.atsuc.Fanctory.strategy.design;

import java.math.BigDecimal;

/**
 * @author csup
 * @creatTime 2024/5/27 12:27
 * @description
 */
public class Context<T> {
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
