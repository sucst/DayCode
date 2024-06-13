package cn.atsuc.spring.four.collection;

import java.util.List;

/**
 * @author csuporg
 * @data 2024/5/7 23:58
 * @email s202011105851@163.com
 * @description
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void testBookOutput() {
        System.out.println(list);
    }
}
