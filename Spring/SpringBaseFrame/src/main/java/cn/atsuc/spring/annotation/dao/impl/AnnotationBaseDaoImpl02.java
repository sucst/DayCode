package cn.atsuc.spring.annotation.dao.impl;

import cn.atsuc.spring.annotation.dao.AnnotationBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author csuporg
 * @date 2024/5/8 23:37
 * @email s202011105851@163.com
 * @description
 */
@Repository(value = "annotationBaseDaoImpl02")
public class AnnotationBaseDaoImpl02 implements AnnotationBaseDao {
    @Override
    public void add() {
        System.out.println("annotationBaseDaoImpl02 02");
    }
}
