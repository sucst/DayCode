package cn.atsuc.Fanctory.ChainOfResponsibility.impl;

import cn.atsuc.Fanctory.ChainOfResponsibility.Approver;
import cn.atsuc.Fanctory.ChainOfResponsibility.PurchaseRequest;

/**
 * @author csup
 * @creatTime 2024/5/16 12:35
 * @description 院长审批人
 */
public class DepartmentHeadApprover extends Approver {

    public DepartmentHeadApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 5000 && purchaseRequest.getPrice() <= 10000) {
            System.out.println("请求编号：" + purchaseRequest.getId() + "，处理人：" + this.name);
        } else {
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
