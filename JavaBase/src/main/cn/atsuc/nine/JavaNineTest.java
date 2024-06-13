package cn.atsuc.nine;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author atsuc
 * @date 2024/6/12 20:05
 * @email s202011105851@163.com
 * @description JAVA9特性测试
 */
public class JavaNineTest {
    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://www.atsuc.cn");
    }

    @Test
    public void test1() {
        // 钻石操作符与匿名内部类在Java中不能共存，但是在9中可以共存
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        // jdk1.7中的新特性，编译类型推断
        ArrayList<String> list = new ArrayList<>();
    }
    // java9 try 操作升级
    @Test
    public void test2() {
        //java 8之前的资源关闭的操作
//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] cbuf = new char[20];
//            int len;
//            if((len = reader.read(cbuf) )!= -1){
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(reader != null){
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }

        //java 8中资源关闭操作: Java 8 中，可以实现资源的自动关闭
        //要求自动关闭的资源的实例化必须放在try的一对小括号中
//        try(InputStreamReader reader = new InputStreamReader(System.in)){
//            char[] cbuf = new char[20];
//            int len;
//            if((len = reader.read(cbuf) )!= -1){
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //java9中资源关闭操作：需要自动关闭的资源的实例化可以放在try的一对小括号外。
        //此时的资源属性是常量，声明为final的，不可修改
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            char[] chars = new char[20];
            int len = 0;
            if ((len = reader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的namesList是一个只读的集合
        namesList = Collections.unmodifiableList(namesList);
        namesList.add("Tom");

        System.out.println(namesList);

    }

    @Test
    public void test4() {
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c")));
        // 如下操作不适用于jdk 8 及之前版本,适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    @Test
    public void test5() {
        //此时得到的集合list也是一个只读集合。
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //报异常
        list.add(6);

    }

    //java9新特性八：集合工厂方法：创建只读集合
    @Test
    public void test6() {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        //不能添加
//        list1.add(6);
        System.out.println(list1);

        Set<Integer> set1 = Set.of(23, 3, 54, 65, 43, 76, 87, 34, 46);
        //不能添加
//        set1.add(4);
        System.out.println(set1);

        Map<String, Integer> map1 = Map.of("Tom", 23, "Jerry", 54, "HanMeimei", 12);
        //不能添加
        //map1.put("Lilei",34);

        System.out.println(map1);

        Map<String, Integer> map2 = Map.ofEntries(Map.entry("Tom", 34), Map.entry("Jerry", 21));
//        map2.put("Lilei",34);
        System.out.println(map2);


    }

    //java9新特性九：InputStream的新方法:tranferTo()
    @Test
    public void test7() {
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream is = cl.getResourceAsStream("hello.txt");
             OutputStream os = new FileOutputStream("src\\hello1.txt")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //java9新特性十：Stream API的加强
    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(23, 43, 45, 55, 61, 54, 32, 2, 45, 89, 7);
        //takeWhile 返回从开头开始的按照指定规则尽量多的元素
//        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        //dropWhile():与 takeWhile 相反，返回剩余的元素。
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }

    @Test
    public void test9(){
        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream1 = Stream.of(1, 2, 3,null);
        stream1.forEach(System.out::println);
        //of()参数不能存储单个null值。否则，报异常
//        Stream<Object> stream2 = Stream.of(null);
//        stream2.forEach(System.out::println);
        Integer i = 10;
        i = null;
        //ofNullable()：形参变量是可以为null值的单个元素
        Stream<Integer> stream3 = Stream.ofNullable(i);
        long count = stream3.count();
        System.out.println(count);
    }

    @Test
    public void test10(){

        Stream.iterate(0,x -> x + 1).limit(10).forEach(System.out::print);

        System.out.println();
        //java9中新增的重载的方法
        Stream.iterate(0,x -> x < 100,x -> x + 1).forEach(System.out::print);
    }

    //java9新特性十一：Optional提供了新的方法stream()
    @Test
    public void test11(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");

        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
//        long count = stream.count();
//        System.out.println(count);
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }

}
