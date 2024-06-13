package cn.atsuc.Fanctory.strategy.demo;

import cn.atsuc.Fanctory.strategy.demo.behavior.BadFlyBehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.CanSwimHehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.GagaQuarkBehavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:34
 * @description
 */
public class PekingDuck extends Duck {
    public PekingDuck() {
        super();
        quarkBehavior = new GagaQuarkBehavior();
        swimBehavior = new CanSwimHehavior();
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("======北京鸭======");
    }
}
