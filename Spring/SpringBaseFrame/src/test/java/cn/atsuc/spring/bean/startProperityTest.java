package cn.atsuc.spring.bean;

import cn.atsuc.spring.startProperity.Order;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/8 19:37
 * @email s202011105851@163.com
 * @description
 */
public class startProperityTest {

    @Test
    public void testStart01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("startProperity.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("第四步 获取创建对象bean实例对象");
        System.out.println("order: "+order);

        context.close();
    }
}
