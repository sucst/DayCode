package cn.atsuc.spring.bean;

import cn.atsuc.spring.two.service.userService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/7 21:51
 * @email s202011105851@163.com
 * @description
 */
public class TwoTest {

    @Test
    public void testTwo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        userService bean = context.getBean("userService", userService.class);
        bean.add();
    }
}
