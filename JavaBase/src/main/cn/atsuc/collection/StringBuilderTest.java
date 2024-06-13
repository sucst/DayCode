package cn.atsuc.collection;

import org.junit.Test;

/**
 * @author atsuc
 * @date 2024/6/3 22:47
 * @email s202011105851@163.com
 * @description
 */
public class StringBuilderTest {

    @Test
    public void stringBuilderTest() {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuilder builder = new StringBuilder("");
        StringBuffer buffer = new StringBuffer("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 执行时间: "+(endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 执行时间: "+(endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 执行时间: "+(endTime - startTime));

    }
}
