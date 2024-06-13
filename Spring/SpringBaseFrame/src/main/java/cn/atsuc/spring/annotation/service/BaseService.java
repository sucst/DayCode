package cn.atsuc.spring.annotation.service;

import org.springframework.stereotype.Component;

/**
 * @author csuporg
 * @data 2024/5/8 22:55
 * @email s202011105851@163.com
 * @description
 */

//  在注解里面value属性值可以省略不写,
// 默认值是类名称，首字母小写
@Component(value = "baseService")  // <==> <bean id="baseService" class="cn.atsuc.spring.annotation.service.BaseService"/>
public class BaseService {
    public void add() {
        System.out.println(" BaseService start ... ");
    }
}
