package cn.atsuc.Fanctory.strategy.demo;

import cn.atsuc.Fanctory.strategy.demo.behavior.NoFlyBehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.NoQuarkBehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.NoSwimHehavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:35
 * @description
 */
public class ToyDuck extends Duck {
    public ToyDuck() {
        super();
        quarkBehavior = new NoQuarkBehavior();
        swimBehavior = new NoSwimHehavior();
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("======玩具鸭======");
    }
}
