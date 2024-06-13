package cn.atsuc.tools.proxy;

/**
 * @author atsuc
 * @date 2024/6/11 23:48
 * @email s202011105851@163.com
 * @description 被代理类
 */
public class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "I believe I can fly high !!!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like to eat " + food);
    }
}
