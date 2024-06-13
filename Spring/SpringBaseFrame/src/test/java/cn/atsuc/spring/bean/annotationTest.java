package cn.atsuc.spring.bean;

import cn.atsuc.spring.annotation.config.springConfig;
import cn.atsuc.spring.annotation.service.AnnotationBaseService;
import cn.atsuc.spring.annotation.service.BaseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/8 23:05
 * @email s202011105851@163.com
 * @description
 */
public class annotationTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        BaseService service = context.getBean("baseService", BaseService.class);
        service.add();
    }

    @Test
    public void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        AnnotationBaseService service = context.getBean("annotationBaseService", AnnotationBaseService.class);
        service.add();
//        service.add2();
    }

    @Test
    public void testConfigAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
        AnnotationBaseService service = context.getBean("annotationBaseService", AnnotationBaseService.class);
        service.add();
//        service.add2();
    }
}
