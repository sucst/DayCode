package cn.atsuc.designmodel.mediator;

import cn.atsuc.Fanctory.mediatorPattern.two.*;
import org.junit.Test;

/**
 * @author csup
 * @creatTime 2024/5/21 9:35
 * @description
 */
public class mediatorTest {

    @Test
    public void test() {
        //创建中介者
        Mediator mediator = new ConcreteMediator();

//创建各个同事类，并加入Mediator中介者的Map对象中
        Alarm alarm = new Alarm(mediator);
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator);
        Curtain curtain = new Curtain(mediator);
        TV tv = new TV(mediator);

//闹钟响起
        alarm.openAlarm();
        coffeeMachine.completeCoffee();
        tv.closeTV();
    }
}
