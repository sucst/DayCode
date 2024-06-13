package cn.atsuc.spring.bean;

import cn.atsuc.spring.jdbc.entity.User;
import cn.atsuc.spring.jdbc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

/**
 * @author csuporg
 * @date 2024/5/10 21:28
 * @email s202011105851@163.com
 * @description
 */
public class jdbcTest {

    @Test
    public void JdbcTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcConfig.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setId(123456L);
        user.setUserAccount("admin");
        user.setUserPassword("123456");
        user.setUserName("admin");
        user.setUserAvatar("");
        user.setUserRole("admin");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setIsDelete(0);
        userService.add(user);
    }
}
