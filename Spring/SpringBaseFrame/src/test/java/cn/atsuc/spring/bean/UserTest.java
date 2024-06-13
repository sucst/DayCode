package cn.atsuc.spring.bean;

import cn.atsuc.spring.one.Vo.Book;
import cn.atsuc.spring.one.Vo.Orders;
import cn.atsuc.spring.one.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/6 23:17
 * @email s202011105851@163.com
 * @description
 */
public class UserTest {

    @Test
    public void testUser() {
        // add bean.xml
        BeanFactory context = new ClassPathXmlApplicationContext("bean.xml");
        // get bean target
        User user = context.getBean("user", User.class);
        System.out.println(user.getName()+user.getAge());
    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.testBook();
    }

    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);

        orders.testOrders();
    }
}
