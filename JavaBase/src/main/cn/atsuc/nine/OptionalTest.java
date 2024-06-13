package cn.atsuc.nine;

import org.junit.Test;

import java.util.Optional;

/**
 * @author atsuc
 * @date 2024/6/12 20:48
 * @email s202011105851@163.com
 * @description optional 特性测试
 */
public class OptionalTest {

    @Test
    public void test() {
        // empty():创建的optional对象内部的value=null
        Optional<Object> empty = Optional.empty();
        if (empty.isPresent()) { // Optional封装数据是否包含数据
            System.out.println("数据为空");
        }
        System.out.println(empty);
        System.out.println(empty.isPresent());
    }

    @Test
    public void test1() {
        String str = "hello";
        // of() 封装数据生成optional对象，要求t非空，空报错
        Optional<String> str1 = Optional.of(str);
        String s = str1.get();
        System.out.println(s);
    }

    @Test
    public void test2() {
        String str = "peaking";
        str = null;

        // ofNullable 数据封装给value，不要求t非空
        Optional<String> str1 = Optional.ofNullable(str);
        // ofElse ，空返回给定值
        String str2 = str1.orElse("shanghai");
        System.out.println(str2);
    }
}
