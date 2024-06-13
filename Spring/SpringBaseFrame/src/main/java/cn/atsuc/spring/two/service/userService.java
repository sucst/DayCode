package cn.atsuc.spring.two.service;

import cn.atsuc.spring.two.dao.UserDao;

/**
 * @author csuporg
 * @data 2024/5/7 21:41
 * @email s202011105851@163.com
 * @description
 */
public class userService {

    // 2.
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add() {
        System.out.println("service add...");
        userDao.update();

        // 1.
        //        UserDao dao = new UserDaoImpl();
        //        dao.update();
    }
}
