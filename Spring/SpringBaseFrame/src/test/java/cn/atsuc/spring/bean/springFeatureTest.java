package cn.atsuc.spring.bean;

import cn.atsuc.spring.Feature.BmVo;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author csuporg
 * @date 2024/5/11 20:03
 * @email s202011105851@163.com
 * @description
 */
public class springFeatureTest {

    // 函数式编程
    @Test
    public void testGenericApplicationContext() {
        // 创建对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 调用context方法
        context.refresh();
        context.registerBean(BmVo.class, () -> new BmVo());
        context.registerBean("bmvo1", BmVo.class, ()-> new BmVo());
        // 获取对象
        BmVo bean = (BmVo) context.getBean("cn.atsuc.spring.Feature.BmVo");
        Object bmvo1 = context.getBean("bmvo1");
        System.out.println(bmvo1);
        System.out.println(bean);
    }

}
