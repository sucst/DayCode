package cn.atsuc.spring.bean;

import cn.atsuc.spring.four.collection.Course;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/8 0:42
 * @email s202011105851@163.com
 * @description
 */
public class BeanFactoryTest {
    @Test
    public void testBeanFactory() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanFactory.xml");
        Course myBean = context.getBean("myBean", Course.class);
        System.out.println(myBean);
    }
}
