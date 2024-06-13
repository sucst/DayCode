package cn.atsuc.spring.bean;


import cn.atsuc.spring.aop.aopUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @date 2024/5/10 0:32
 * @email s202011105851@163.com
 * @description
 */
public class aopTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aopConfig.xml");
        aopUser user = context.getBean("aopUser", aopUser.class);
        user.add();
    }
}
