package cn.atsuc.Fanctory.strategy.demo.behavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:31
 * @description “咯咯叫”行为策略对象
 */
public class GegeQuarkBehavior implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("咯咯叫~");
    }
}