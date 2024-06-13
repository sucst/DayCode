package cn.atsuc.Fanctory.strategy.demo;

import cn.atsuc.Fanctory.strategy.demo.behavior.CanSwimHehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.GegeQuarkBehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.GoodFlyBehavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:34
 * @description
 */
public class WildDuck extends Duck {
    public WildDuck() {
        super();
        quarkBehavior = new GegeQuarkBehavior();
        swimBehavior = new CanSwimHehavior();
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("======野鸭子======");
    }
}
