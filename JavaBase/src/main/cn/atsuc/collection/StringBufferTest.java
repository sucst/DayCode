package cn.atsuc.collection;

import org.junit.Test;

/**
 * @author atsuc
 * @date 2024/6/3 20:28
 * @email s202011105851@163.com
 * @description
 */
public class StringBufferTest {

    @Test
    public void StringBufferTest01() {
        String string = new String("喜欢看小电影");
        StringBuffer buffer = new StringBuffer("喜欢看小电影");
        buffer.append("有颜色");

        System.out.println(string);
        System.out.println(buffer);
    }

    @Test
    public void StringBufferTest02() {

    }
}
