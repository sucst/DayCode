package cn.atsuc.Fanctory.command.demo;

/**
 * @author csup
 * @creatTime 2024/5/17 13:52
 * @description 命令角色
 */
public interface Command {
    void execute();
    void undo();
}
