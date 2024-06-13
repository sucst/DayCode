package cn.atsuc.tools.proxy;

import java.lang.reflect.Proxy;

/**
 * @author atsuc
 * @date 2024/6/11 23:50
 * @email s202011105851@163.com
 * @description
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */
public class ProxyFactory {
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object target) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
