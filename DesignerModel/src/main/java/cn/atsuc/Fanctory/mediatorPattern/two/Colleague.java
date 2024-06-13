package cn.atsuc.Fanctory.mediatorPattern.two;

/**
 * @author csup
 * @creatTime 2024/5/21 9:32
 * @description
 */
public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return this.mediator;
    }

    public void sendMsg(Integer state) {
        this.getMediator().getMsg(state, this.getClass().getSimpleName());
    }
}
