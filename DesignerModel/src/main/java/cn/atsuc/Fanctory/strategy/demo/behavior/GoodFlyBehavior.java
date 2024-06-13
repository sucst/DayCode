package cn.atsuc.Fanctory.strategy.demo.behavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:33
 * @description
 */
public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("很会飞~");
    }
}
