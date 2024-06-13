package cn.atsuc.file.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author atsuc
 * @date 2024/6/9 22:15
 * @email s202011105851@163.com
 * @description
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);
    }
}
