package cn.atsuc.designmodel.strategy;

import cn.atsuc.Fanctory.strategy.demo.behavior.NoFlyBehavior;
import cn.atsuc.Fanctory.strategy.demo.Duck;
import cn.atsuc.Fanctory.strategy.demo.PekingDuck;
import cn.atsuc.Fanctory.strategy.demo.ToyDuck;
import cn.atsuc.Fanctory.strategy.demo.WildDuck;
import cn.atsuc.Fanctory.strategy.design.Context;
import cn.atsuc.Fanctory.strategy.design.event.MJCouponDiscount;
import cn.atsuc.Fanctory.strategy.design.event.NYGCouponDiscount;
import cn.atsuc.Fanctory.strategy.design.event.ZJCouponDiscount;
import cn.atsuc.Fanctory.strategy.design.event.ZKCouponDiscount;
import org.junit.Test;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author csup
 * @creatTime 2024/5/24 9:36
 * @description
 */
public class StrategyTest {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(StrategyTest.class);
    @Test
    public void test() {
        Duck wildDuck = new WildDuck();
        wildDuck.quark();
        wildDuck.swim();
        wildDuck.fly();

        Duck pekingDuck = new PekingDuck();
        pekingDuck.quark();
        pekingDuck.swim();
        pekingDuck.fly();
        System.out.println("===改变策略===");
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        pekingDuck.fly();

        Duck toyDuck = new ToyDuck();
        toyDuck.quark();
        toyDuck.swim();
        toyDuck.fly();
    }

    @Test
    public void test_zj() {
        // 直减；100-10，商品100元
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_mj() {
        // 满100减10，商品100元
        Context<Map<String,String>> context = new Context<Map<String,String>>(new MJCouponDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_zk() {
        // 折扣9折，商品100元
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        logger.info("测试结果：折扣9折后金额 {}", discountAmount);
    }

    @Test
    public void test_nyg() {
        // n元购；100-10，商品100元
        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        logger.info("测试结果：n元购优惠后金额 {}", discountAmount);
    }
}
