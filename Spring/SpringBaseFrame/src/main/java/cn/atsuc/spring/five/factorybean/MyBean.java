package cn.atsuc.spring.five.factorybean;

import cn.atsuc.spring.four.collection.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author csuporg
 * @data 2024/5/8 0:39
 * @email s202011105851@163.com
 * @description
 */
public class MyBean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("MyBean is fact : Course");
        return course;
    }
    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
