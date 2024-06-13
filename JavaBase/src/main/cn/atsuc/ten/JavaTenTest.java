package cn.atsuc.ten;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author atsuc
 * @date 2024/6/12 21:00
 * @email s202011105851@163.com
 * @description java10特性测试
 */
public class JavaTenTest {

    // 特性一: 局部变量推断
    @Test
    public void test() {
        // 声明变量时，根据所附的值推断
        var num = 10;

        var list = new ArrayList<Integer>();
        list.add(1);

        for (var i : list) {
            System.out.println(i);
            System.out.println(i.getClass());
        }

        // 普通运算
        for (var i = 0; i < 9; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        // 1. 局部变量不赋值，不能进行类型推断
//        var num;

       // 2. lambda 左边不能为var
        Supplier<Double> sup = () -> Math.random();
//        var sup = () -> Math.random();

        // 3. 方法引用中，左边的函数式接口不能声明为var
        Consumer<String> con = System.out::println;
//        var coon = System.out::println;

        // 4. 数组静态初始化中，注意如下情况不可以
        int[] arr = {1,2,3,4,5,6,7,8,9};
//        var arr = {1,2,3};
    }

    @Test
    public void test3() {
//        情况1：没有初始化的局部变量声明
//        var s = null;

    //情况2：方法的返回类型
//    public var method1(){
//
////        return 0;
//    }
    // 情况3：方法的参数类型
//    public void method2(var num){
//
//    }

    //情况4：构造器的参数类型
//    public Java10Test(var i){
//
//    }

    //情况5：属性
//    var num;


//        情况6：catch块
//        try{
//
//        }catch(var e){
//            e.printStackTrace();
//        }
    }

    // copyOf 只用只读的集合; 改变值则为false
    @Test
    public void test4() {
        var list = List.of("java", "python");
        var listCopy = List.copyOf(list);
        System.out.println(listCopy == list); // true


        var listArrays = new ArrayList<String>();
        listArrays.add("hahaha");
        var listArraysCopy = List.copyOf(listArrays);
        System.out.println(listArraysCopy == listArrays); // false


        //示例1和2代码基本一致，为什么一个为true,一个为false?
        //结论：copyOf(Xxx coll):如果参数coll本身就是一个只读集合，则copyOf()返回值即为当前的coll
        //如果参数coll不是一个只读集合，则copyOf()返回一个新的集合，这个集合是只读的。
    }
}
