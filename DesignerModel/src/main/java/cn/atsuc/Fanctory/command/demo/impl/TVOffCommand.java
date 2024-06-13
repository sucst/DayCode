package cn.atsuc.Fanctory.command.demo.impl;

import cn.atsuc.Fanctory.command.demo.Command;
import cn.atsuc.Fanctory.command.demo.receiver.TVReceiver;

/**
 * @author csup
 * @creatTime 2024/5/17 13:56
 * @description
 */
public class TVOffCommand implements Command {
    private TVReceiver tv;

    public TVOffCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
