package cn.atsuc.Fanctory.command.demo.impl;

import cn.atsuc.Fanctory.command.demo.Command;
import cn.atsuc.Fanctory.command.demo.receiver.LightReceiver;

/**
 * @author csup
 * @creatTime 2024/5/17 13:55
 * @description 具体的命令角色
 */
public class LightOnCommand implements Command {

    private LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
