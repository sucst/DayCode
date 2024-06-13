package cn.atsuc.Fanctory.strategy.demo;

import cn.atsuc.Fanctory.strategy.demo.behavior.FlyBehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.QuarkBehavior;
import cn.atsuc.Fanctory.strategy.demo.behavior.SwimBehavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:34
 * @description
 */
public abstract class Duck {
    protected QuarkBehavior quarkBehavior;
    protected SwimBehavior swimBehavior;
    protected FlyBehavior flyBehavior;

    public Duck() {
        display();
    }

    public void quark() {
        if (quarkBehavior != null) {
            quarkBehavior.quark();
        }
    }

    public void swim() {
        if (swimBehavior != null) {
            swimBehavior.swim();
        }
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void setQuarkBehavior(QuarkBehavior quarkBehavior) {
        this.quarkBehavior = quarkBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();
}
