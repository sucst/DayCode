package cn.atsuc.Fanctory.command.demo.impl;

import cn.atsuc.Fanctory.command.demo.Command;
import cn.atsuc.Fanctory.command.demo.receiver.LightReceiver;

/**
 * @author csup
 * @creatTime 2024/5/17 13:55
 * @description
 */
public class LightOffCommand implements Command {
    private LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
