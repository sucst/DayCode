package cn.atsuc.spring.bean;

import cn.atsuc.spring.three.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/7 21:51
 * @email s202011105851@163.com
 * @description
 */
public class ThreeTest {

    @Test
    public void testThree() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("user", Emp.class);
        emp.outPut();
    }

    @Test
    public void testFour() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Emp emp = context.getBean("user", Emp.class);
        emp.outPut();
    }
}
