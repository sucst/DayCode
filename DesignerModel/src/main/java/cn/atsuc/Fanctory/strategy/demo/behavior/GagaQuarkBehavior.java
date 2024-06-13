package cn.atsuc.Fanctory.strategy.demo.behavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:30
 * @description  “嘎嘎叫”行为策略对象
 */
public class GagaQuarkBehavior implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("嘎嘎叫~");
    }
}
