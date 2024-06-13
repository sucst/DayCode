package cn.atsuc.spring.annotation.service;

import cn.atsuc.spring.annotation.dao.AnnotationBaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author csuporg
 * @data 2024/5/8 23:37
 * @email s202011105851@163.com
 * @description
 */
@Service
public class AnnotationBaseService {

    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解
//    @Autowired // 根据属性注入
//    @Qualifier(value = "annotationBaseDaoImpl01")
//    @Resource // 根据类型注入
    @Resource(name = "annotationBaseDaoImpl01") // 名称注入
    private AnnotationBaseDao annotationBaseDao;
    public void add() {
        System.out.println("service add....");
        annotationBaseDao.add();
    }

//    @Autowired // 根据属性注入
//    @Qualifier(value = "annotationBaseDaoImpl02")
//    private AnnotationBaseDao annotationBaseDao2;
//    public void add2() {
//        System.out.println("service add....");
//        annotationBaseDao2.add();
//    }


}
