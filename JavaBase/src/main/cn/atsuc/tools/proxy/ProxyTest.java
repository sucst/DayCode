package cn.atsuc.tools.proxy;

import org.junit.Test;

/**
 * @author atsuc
 * @date 2024/6/11 23:46
 * @email s202011105851@163.com
 * @description 动态代理的举例
 */
public class ProxyTest {
    @Test
    public void test() {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat(" tu fu");
        System.out.println("======================");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory  nikeFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        nikeFactory.produceCloth();
    }
}
