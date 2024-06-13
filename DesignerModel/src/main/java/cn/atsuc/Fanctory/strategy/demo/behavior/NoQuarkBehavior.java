package cn.atsuc.Fanctory.strategy.demo.behavior;

/**
 * @author csup
 * @creatTime 2024/5/24 9:30
 * @description
 */
public class NoQuarkBehavior implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("不会叫~");
    }
}
