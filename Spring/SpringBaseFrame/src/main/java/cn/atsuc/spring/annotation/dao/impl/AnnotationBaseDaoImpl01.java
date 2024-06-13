package cn.atsuc.spring.annotation.dao.impl;

import cn.atsuc.spring.annotation.dao.AnnotationBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author csuporg
 * @data 2024/5/8 23:37
 * @email s202011105851@163.com
 * @description
 */
@Repository(value = "annotationBaseDaoImpl01")
public class AnnotationBaseDaoImpl01 implements AnnotationBaseDao {
    @Override
    public void add() {
        System.out.println("annotationBaseDaoImpl01 01");
    }
}
