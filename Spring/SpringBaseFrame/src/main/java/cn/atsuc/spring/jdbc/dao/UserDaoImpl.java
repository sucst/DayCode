package cn.atsuc.spring.jdbc.dao;

import cn.atsuc.spring.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author csuporg
 * @date 2024/5/10 20:57
 * @email s202011105851@163.com
 * @description
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "INSERT INTO " +
                "`user` " +
                "( `id`,`userAccount`, `userPassword`, `userName`, `userAvatar`, `userRole`, `createTime`, `updateTime`, `isDelete` )" +
                "VALUES (?, ?, ?,?, ?,?,?,?,?)";
        Object[] agrs = {user.getId(), user.getUserAccount(), user.getUserPassword(), user.getUserName(), user.getUserAvatar(), user.getUserRole(), user.getCreateTime(), user.getUpdateTime(), user.getIsDelete()};
        int update = jdbcTemplate.update(sql, agrs);
        System.out.println(update);
    }
}
