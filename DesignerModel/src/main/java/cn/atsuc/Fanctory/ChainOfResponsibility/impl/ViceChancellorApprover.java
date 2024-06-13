package cn.atsuc.Fanctory.ChainOfResponsibility.impl;

import cn.atsuc.Fanctory.ChainOfResponsibility.Approver;
import cn.atsuc.Fanctory.ChainOfResponsibility.PurchaseRequest;

import java.util.NoSuchElementException;

/**
 * @author csup
 * @creatTime 2024/5/16 12:41
 * @description
 */
public class ViceChancellorApprover extends Approver {

    public ViceChancellorApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 10000 && purchaseRequest.getPrice() <= 30000)
            System.out.println("请求编号：" + purchaseRequest.getId() + "，处理人：" + this.name);
        else
            nextApprover.processRequest(purchaseRequest);
    }
}
