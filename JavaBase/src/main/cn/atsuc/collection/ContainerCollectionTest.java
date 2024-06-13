package cn.atsuc.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author atsuc
 * @date 2024/6/5 1:01
 * @email s202011105851@163.com
 * @description
 */
public class ContainerCollectionTest {
    // List嵌套List
    @Test
    public void test() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("杨过");
        list1.add("小龙女");
        list1.add("尹志平");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("涛哥");
        list2.add("金莲");
        list2.add("三上");

        /*
           list中的元素是两个 ArrayList<String>
           所以泛型也应该是 ArrayList<String>
         */
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);

        /*
          先遍历大集合,将两个小集合遍历出来
          再遍历两个小集合,将元素获取出来
         */
        for (ArrayList<String> arrayList : list) {
            for (String s : arrayList) {
                System.out.println(s);
            }
        }
    }
    // .List嵌套Map
    @Test
    public void test2() {
        //1.创建两个map集合
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1,"张三");
        map1.put(2,"李四");
        map1.put(3,"王五");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1,"黄晓明");
        map2.put(2,"杨颖");
        map2.put(3,"刘德华");

        //2.创建一个存储map集合的list集合
        ArrayList<HashMap<Integer, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        //3.先遍历list集合,再遍历map集合
        for (HashMap<Integer, String> map : list) {
            Set<Map.Entry<Integer, String>> set = map.entrySet();
            for (Map.Entry<Integer, String> entry : set) {
                System.out.println(entry.getKey()+"..."+entry.getValue());
            }
        }
    }
    // Map嵌套Map
    @Test
    public void test3() {
        //1.创建两个map集合
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1,"张三");
        map1.put(2,"李四");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1,"王五");
        map2.put(2,"赵六");

        HashMap<String, HashMap<Integer, String>> map = new HashMap<>();
        map.put("javase",map1);
        map.put("javaee",map2);

        Set<Map.Entry<String, HashMap<Integer, String>>> set = map.entrySet();
        for (Map.Entry<String, HashMap<Integer, String>> entry : set) {
            HashMap<Integer, String> hashMap = entry.getValue();
            Set<Integer> set1 = hashMap.keySet();
            for (Integer key : set1) {
                System.out.println(key+"..."+hashMap.get(key));
            }
        }
    }
}
