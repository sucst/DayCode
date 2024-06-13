package cn.atsuc.spring.bean;

import cn.atsuc.spring.four.collection.Book;
import cn.atsuc.spring.four.collection.CollectionXML;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author csuporg
 * @data 2024/5/7 23:09
 * @email s202011105851@163.com
 * @description
 */
public class FourTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        CollectionXML collection = context.getBean("collection", CollectionXML.class);
        collection.testOut();
    }
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        CollectionXML collection = context.getBean("collection", CollectionXML.class);
        collection.testOut();
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        Book book = context.getBean("book", Book.class);
        book.testBookOutput();
    }
}
