package cn.atsuc.spring.bean;

import cn.atsuc.spring.autowire.Dept;
import cn.atsuc.spring.autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/8 20:27
 * @email s202011105851@163.com
 * @description
 */
public class AutowireTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp.toString());

        Dept dept1 = context.getBean("dept1", Dept.class);
        System.out.println(dept1.toString());

        Dept dept2 = context.getBean("dept2", Dept.class);
        System.out.println(dept2.toString());
    }
}
