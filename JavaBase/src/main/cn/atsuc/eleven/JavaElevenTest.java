package cn.atsuc.eleven;

import org.junit.Test;

/**
 * @author atsuc
 * @date 2024/6/12 21:21
 * @email s202011105851@163.com
 * @description java 11 特性测试
 */
public class JavaElevenTest {

    // 1. String 中新增方法
    @Test
    public void test() {
        // isBlank() : 判断字符串是否为空
        System.out.println(" \t".isBlank());
        // strip():去除收尾空白
        System.out.println("---------"+ " \t abb ".strip() + "------------");
        System.out.println("---------"+ " \t abb ".trim() + "------------");
        System.out.println("----首部空格-----"+ " \t abb ".stripLeading() + "------------");
        System.out.println("-----尾部空格----"+ " \t abb ".stripTrailing() + "------------");

        String str = "abc";
        String repeatStr = str.repeat(5);
        System.out.println(repeatStr);

        String str2 = "abc\n tigi\b you";
        System.out.println(str2.lines().count());
    }
}
