package cn.atsuc.designmodel.command;

import cn.atsuc.Fanctory.command.demo.*;
import cn.atsuc.Fanctory.command.demo.impl.LightOffCommand;
import cn.atsuc.Fanctory.command.demo.impl.LightOnCommand;
import cn.atsuc.Fanctory.command.demo.impl.TVOffCommand;
import cn.atsuc.Fanctory.command.demo.impl.TVOnCommand;
import cn.atsuc.Fanctory.command.demo.receiver.LightReceiver;
import cn.atsuc.Fanctory.command.demo.receiver.TVReceiver;
import cn.atsuc.Fanctory.command.two.group.Employee;
import cn.atsuc.Fanctory.command.two.group.GroupStructure;
import cn.atsuc.Fanctory.command.two.group.Link;
import cn.atsuc.Fanctory.command.two.lang.Iterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author csup
 * @creatTime 2024/5/17 13:57
 * @description
 */
public class CommandTest {

    private Logger logger = LoggerFactory.getLogger(CommandTest.class);

    @Test
    public void testCommand() {
        // 初始化遥控器
        RemoteController remoteController = new RemoteController();
// 操作电灯
        int no = 0;
        LightReceiver light = new LightReceiver();
        remoteController.setCommands(no, new LightOnCommand(light), new LightOffCommand(light));
        remoteController.onBtnCommand(no);
        remoteController.offBtnCommand(no);
        remoteController.undoBtnCommand();
// 操作电视
        no = 1;
        TVReceiver tv = new TVReceiver();
        remoteController.setCommands(no, new TVOnCommand(tv), new TVOffCommand(tv));
        remoteController.onBtnCommand(no);
        remoteController.offBtnCommand(no);
        remoteController.undoBtnCommand();
    }



    @Test
    public void test_iterator() {
        GroupStructure groupStructure = new GroupStructure("1", "小傅哥");
        groupStructure.add(new Employee("2", "花花", "二级部门"));
        groupStructure.add(new Employee("3", "豆包", "二级部门"));
        groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        groupStructure.add(new Employee("5", "大烧", "三级部门"));
        groupStructure.add(new Employee("6", "虎哥", "四级部门"));
        groupStructure.add(new Employee("7", "玲姐", "四级部门"));
        groupStructure.add(new Employee("8", "秋雅", "四级部门"));

        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));

        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));

        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            logger.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getuId(), employee.getName());
        }

    }
}
