package cn.atsuc.Fanctory.strategy.demo.behavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:32
 * @description
 */
public class CanSwimHehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("会游泳~");
    }
}
