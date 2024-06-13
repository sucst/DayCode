package cn.atsuc.spring.startProperity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author csuporg
 * @data 2024/5/8 19:50
 * @email s202011105851@163.com
 * @description
 */
public class OrderBeanLife implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" 在初始化之前的方法执行了");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" 在初始化之后的方法执行了");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
