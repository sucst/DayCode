package cn.atsuc.nine;

import org.junit.Test;

/**
 * @author atsuc
 * @date 2024/6/12 20:39
 * @email s202011105851@163.com
 * @description
 */
public class MyInterfaceImpl implements MyInterface{
    @Override
    public void methodAbstract() {
        System.out.println(" methodAbstract");
    }

    @Override
    public void methodDefault() {
        MyInterface.super.methodDefault();
        System.out.println("实现了接口中默认的方法");
    }

    @Test
    public void test() {
        // 接口中的静态方法只能自己调用
        MyInterface.methodStatic();
        // 接口的实现类不能调用静态方法
//        MyInterfaceImpl.methodStatic();
        MyInterfaceImpl myinter = new MyInterfaceImpl();
        myinter.methodDefault();
        // 接口私有方法不能在外部调用
//        myinter.methodPrivate();
    }
}