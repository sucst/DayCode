package cn.atsuc.designmodel.template;

import cn.atsuc.Fanctory.template.design.NetMall;
import cn.atsuc.Fanctory.template.design.group.JDNetMall;
import org.junit.Test;

/**
 * @author csup
 * @creatTime 2024/5/27 18:32
 * @description
 */
public class templateTest {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(templateTest.class);
    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }
}
