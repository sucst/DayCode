package cn.atsuc.Fanctory.mediatorPattern.two;

/**
 * @author csup
 * @creatTime 2024/5/21 9:31
 * @description
 */
public abstract class Mediator {
    public abstract void registerColleague(Colleague colleague);

    public abstract void getMsg(Integer state, String name);

    public abstract void sendMsg();
}
