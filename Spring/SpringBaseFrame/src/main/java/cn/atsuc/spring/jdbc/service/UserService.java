package cn.atsuc.spring.jdbc.service;

import cn.atsuc.spring.jdbc.dao.UserDao;
import cn.atsuc.spring.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author csuporg
 * @date 2024/5/10 20:47
 * @email s202011105851@163.com
 * @description
 */

/**
 *  REQUIRED    Support a current transaction, create a new one if none exists.
 *  MANDATORY   Support a current transaction, throw an exception if none exists.
 *  NESTED      Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise.
 *  NEVER       NOT_SUPPORTED Execute non-transactionally, suspend the current transaction if one exists.
 *  REQUIRES_NEW Create a new transaction, and suspend the current transaction if one exists.
 * Support a current transaction, execute non-transactionally if none exists.Execute non-transactionally, throw an exception if a transaction exists.
 *
 * Isolation : 隔离级别
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED) // 开启事务注解--1.可以作用在类上或方法上
public class UserService {
    @Autowired
    private UserDao userDao;

    public void add(User user) {
        userDao.add(user);
    }

    public void addAll(User user) {
        userDao.add(user);
    }
}
