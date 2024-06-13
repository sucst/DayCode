package cn.atsuc.collection;

import cn.atsuc.collection.vo.Person;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author atsuc
 * @date 2024/6/2 0:35
 * @email s202011105851@163.com
 * @description string类测试
 */
public class StringTest {
    @Test
    public void StringTest01() {
        String str = "abc";  // 字面量定义方式
        String str1 = "abc";
        System.out.println(str1.equals(str));

        str = "123";
        System.out.println("str:" + str + "-------------- str1:" + str1);
        System.out.println(str1.equals(str));
    }

    @Test
    public void StringTest02() {
        // 对象的创建
        String str = "abc";
        String newStr = new String("abc"); // 本质上 --》 this.value = new value[0];

//        String originalString = new String(String original); 《==》  等价于 this.value = original.value;
//        String value = new String(char value[]); <==>  this.value = Arrays.copyOf(value, value.length);
//        String str1 = new String(value, offset, count);
    }

    @Test
    public void StringTest03() {
        String s1 = "Java EE";
        String s2 = "Java EE";
        String s3 = new String("Java EE");
        String s4 = new String("Java EE");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // * false
    }

    @Test
    public void StringTest04() {
        Person p1 = new Person();
        p1.name ="atsuc";

        Person p2 = new Person();
        p2.name = "atsuc";

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name == "atsuc");
        System.out.println("-------------------------------");

        Person person01 = new Person();
        person01.setName("atsuc");

        Person person02 = new Person();
        person02.setName("atsuc");

        System.out.println(person01.getName().equals(person02.getName()));
        System.out.println(person01.getName() == person02.getName());
        System.out.println(person01.getName() == "atsuc");
        System.out.println("-------------------------------");
        Person atsuc01 = new Person("atsuc", 18);
        Person atsuc02 = new Person("atsuc", 18);
        System.out.println(atsuc01.name == atsuc02.name);
    }

    @Test
    public void StringTest05() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = (s1 + s2).intern();

        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // true
        System.out.println(s4 == s6); // false
    }
    class StringTest06 {
        String str = new String("good");
        char[] chars = {'t', 'e', 's', 't'};

        public void change(String str, char ch[]) {
            str = "test ok";
            ch[0] = 'b';
        }
    }

    @Test
    public void StringTest06() {
        StringTest06 ex = new StringTest06();
        ex.change(ex.str, ex.chars);
        System.out.println(ex.str + " and " + Arrays.toString(ex.chars));
    }

    @Test
    public void StringTest07() { // 使用正则表达式效率是底下的，除非必要，否则不要使用
        String str = ",12hello453world234ajiofgmysql4356,";
        // 字符替换，开头和结尾有,去掉
        String string = str.replaceAll("\\d+", ",")
                .replaceAll("^(,+)|(,+)$", "");
        System.out.println(string);

        String str1 = "12345";
        // 判断str1 字符中是否全由数字组成
        boolean matches = str1.matches("\\d+");
        System.out.println(matches);

        String tel = "0523-9999888";
        // 判断一个固定的电话号码
        boolean result = tel.matches("0523-\\d{7,8}");
        System.out.println(result);

        String str2 = "hello|world|java";
        String[] strs = str2.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    @Test
    public void StringTest08() {
        // char[] 数组 转 String对象
        char[] chars = {'t', 'e', 's', 't'};
        String str = new String(chars);
        String strSub = new String(chars, 2, 2);
        System.out.println(str+ "---------"+strSub);
        // String对象 -> 数组
        char[] charArray = str.toCharArray();
        char[] subCharArray = strSub.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            System.out.println(" str: "+charArray[i]+" I: "+ i);
            if (i > 1) {
                System.out.println("sub: "+subCharArray[i - 2]);
            }
        }
    }

    @Test
    public void StringTest09() throws UnsupportedEncodingException {
        String str = "爱发";
        System.out.println(str.getBytes("ISO8859-1").length);
        System.out.println(str.getBytes("GBK").length);
        System.out.println(str.getBytes("UTF-8").length);

        System.out.println(new String(str.getBytes("ISO8859-1"), "GBK"));
        System.out.println(new String(str.getBytes("GBK"), "GBK"));
        System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));
    }


}
