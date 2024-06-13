package cn.atsuc.designmodel.chainofresponseblity;

import cn.atsuc.Fanctory.ChainOfResponsibility.*;
import cn.atsuc.Fanctory.ChainOfResponsibility.demo.AuthLink;
import cn.atsuc.Fanctory.ChainOfResponsibility.demo.AuthService;
import cn.atsuc.Fanctory.ChainOfResponsibility.demo.impl.Level1AuthLink;
import cn.atsuc.Fanctory.ChainOfResponsibility.demo.impl.Level2AuthLink;
import cn.atsuc.Fanctory.ChainOfResponsibility.demo.impl.Level3AuthLink;
import cn.atsuc.Fanctory.ChainOfResponsibility.impl.ChancellorApprover;
import cn.atsuc.Fanctory.ChainOfResponsibility.impl.DepartmentHeadApprover;
import cn.atsuc.Fanctory.ChainOfResponsibility.impl.TeachDirectorApprover;
import cn.atsuc.Fanctory.ChainOfResponsibility.impl.ViceChancellorApprover;
import com.alibaba.fastjson2.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @author csup
 * @creatTime 2024/5/16 12:40
 * @description
 */
public class ApproverTest {

    private Logger logger = LoggerFactory.getLogger(ApproverTest.class);
    @Test
    public void test() {
        //创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000.0f);

//创建相关的审批人
        TeachDirectorApprover teachDirectorApprover = new TeachDirectorApprover("童主任");
        DepartmentHeadApprover departmentHeadApprover = new DepartmentHeadApprover("王院长");
        ViceChancellorApprover viceChancellorApprover = new ViceChancellorApprover("钱副校长");
        ChancellorApprover chancellorApprover = new ChancellorApprover("郑校长");

//设置后继者（处理人形成环形）
        teachDirectorApprover.setNextApprover(departmentHeadApprover);
        departmentHeadApprover.setNextApprover(viceChancellorApprover);
        viceChancellorApprover.setNextApprover(chancellorApprover);
        chancellorApprover.setNextApprover(teachDirectorApprover);

//发起一个请求
        teachDirectorApprover.processRequest(purchaseRequest); //请求编号：1，处理人：郑校长
    }

    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("ali", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责人审批，王工");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("ali", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", "模拟二级负责人审批，张经理");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("ali", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", "模拟一级负责人审批，段总");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("ali", "1000998004813441", new Date())));

    }
}
