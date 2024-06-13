package cn.atsuc.Fanctory.command.demo;

import cn.atsuc.Fanctory.command.demo.impl.NonCommand;

/**
 * @author csup
 * @creatTime 2024/5/17 13:53
 * @description 调用者
 */
public class RemoteController {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command restoreCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NonCommand();
            offCommands[i] = new NonCommand();
        }
    }

    public void setCommands(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    public void onBtnCommand(int no) {
        restoreCommand = onCommands[no];
        restoreCommand.execute();
    }

    public void offBtnCommand(int no) {
        restoreCommand = offCommands[no];
        restoreCommand.execute();
    }

    public void undoBtnCommand() {
        restoreCommand.undo();
    }

}
