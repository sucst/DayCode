package cn.atsuc.Fanctory.ChainOfResponsibility;

/**
 * @author csup
 * @creatTime 2024/5/16 9:34
 * @description 抽象审批人对象
 */
public abstract class Approver {

    protected Approver nextApprover;
    protected String name;


    public Approver(String name) {
        this.name = name;
    }

    /**
     * 设置后继者
     *
     * @param nextApprover
     */
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    /**
     * 处理请求的方法
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
