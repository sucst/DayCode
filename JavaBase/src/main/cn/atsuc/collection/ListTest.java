package cn.atsuc.collection;

import cn.atsuc.collection.vo.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author atsuc
 * @date 2024/6/4 20:21
 * @email s202011105851@163.com
 * @description
 */
public class ListTest {

    /*
       区分List中remove(int index)和remove(Object obj)
   */
    @Test
    public void ListTest01() {
        List list = new ArrayList<>(); // 向上转型
        list.add(1);
        list.add(2);
        list.add(3);

        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        list.remove(2);
    }


    /**
        void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

        总结：常用方法
        增：add(Object obj)
        删：remove(int index) / remove(Object obj)
        改：set(int index, Object ele)
        查：get(int index)
        插：add(int index, Object ele)
        长度：size()
        遍历：① Iterator迭代器方式
             ② 增强for循环
             ③ 普通的循环
    */

    // 获取list集合数据方式
    @Test
    public void listTest02() {
        List list = new ArrayList<>();
        list.add(12);
        list.add(2456);
        list.add("aaaAA");

//        方式一 : 迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("******************************");

//        方式二、增强for循环
        for (Object object : list) {
            System.out.println(object);
        }
        System.out.println("******************************");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testListTest03() {
        List list = new ArrayList();
        list.add(1);  // index: 0
        list.add(2);
        list.add("AA");
        list.add("666");
        list.add(666);
        list.add(new Person("Jack", 18));
        list.add(666);
        // int lastIndexOf(Object o); 返回o首次出现的位置，如果不存在，返回-1
        int index = list.lastIndexOf(666);
        System.out.println(index);

        // E remove(int index); 移除指定位置元素，并返回此元素
        Object remove = list.remove(index);
        System.out.println("remove : "+remove);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        Object set = list.set(5, "888");
        System.out.println(set+" -- "+ list);

        List subbedList = list.subList(2, 4); // subList为左闭右开
        System.out.println(subbedList);
        System.out.println(list);
    }


    @Test
    public void testListTest04() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println("插入前: " + list);
        // void add(int index, Object ele):在index位置插入ele元素
        list.add(1, "BB");
        System.out.println("插入后: "+list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List<Integer> list1 = Arrays.asList(1, 2, 4);
        list.addAll(list1);
        System.out.println(list.size());

        // Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));

    }

    @Test
    public void linkedTest02() {
        LinkedList<Object> linkedList = new LinkedList<>();
    }


}
