package cn.atsuc.designmodel.observer;

import cn.atsuc.Fanctory.observer.LotteryResult;
import cn.atsuc.Fanctory.observer.LotteryService;
import cn.atsuc.Fanctory.observer.LotteryServiceImpl;
import com.alibaba.fastjson2.JSON;
import org.junit.Test;

/**
 * @author csup
 * @creatTime 2024/5/21 12:38
 * @description
 */
public class observerTest {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(observerTest.class);
    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}
