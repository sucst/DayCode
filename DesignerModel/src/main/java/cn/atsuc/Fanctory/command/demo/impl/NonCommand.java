package cn.atsuc.Fanctory.command.demo.impl;

import cn.atsuc.Fanctory.command.demo.Command;

/**
 * @author csup
 * @creatTime 2024/5/17 13:53
 * @description 空命令，什么也不干
 */
public class NonCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
