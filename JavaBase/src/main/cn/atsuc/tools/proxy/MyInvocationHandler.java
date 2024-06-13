package cn.atsuc.tools.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author atsuc
 * @date 2024/6/11 23:51
 * @email s202011105851@163.com
 * @description
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void bind(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object invoke = method.invoke(target, args);
        humanUtil.method2();
        return invoke;
    }
}
