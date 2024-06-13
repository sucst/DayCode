package cn.atsuc.collection;

import cn.atsuc.collection.vo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author atsuc
 * @date 2024/6/4 21:37
 * @email s202011105851@163.com
 * @description
    一、Set：存储无序的、不可重复的数据
        以HashSet为例说明：
        1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。

        2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。

    二、添加元素的过程：以HashSet为例：
        我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
        此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
        数组此位置上是否已经有元素：
        如果此位置上没有其他元素，则元素a添加成功。 --->情况1
        如果此位置上有其他元素b(或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
        如果hash值不相同，则元素a添加成功。--->情况2
        如果hash值相同，进而需要调用元素a所在类的equals()方法：
        equals()返回true,元素a添加失败
        equals()返回false,则元素a添加成功。--->情况2

        对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
        jdk 7 :元素a放到数组中，指向原来的元素。
        jdk 8 :原来的元素在数组中，指向元素a
        总结：七上八下

        HashSet底层：数组+链表的结构。
 */
public class SetTest {
    @Test
    public void SetTest01() {
        Set hashSet = new HashSet<>();
        Person person01 = new Person("小明", 18);
        Person person02 = new Person("翠花", 18);
        hashSet.add(person01);
        hashSet.add(person02);
        person01.setName("小红");
        hashSet.remove(person01);

        System.out.println(person01);
        hashSet.add(new Person("1001", 25));
        System.out.println(hashSet);
        hashSet.add(new Person("1001",27));
        System.out.println(hashSet);
    }

    // 在List内去除重复数字值，要求尽量简单

    @Test
    public void SetTest02() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    private List duplicateList(List list) {
        // 方法一、
//        Set hashSet = new HashSet();
//        hashSet.addAll(list);
        // 方法二、
        HashSet hashSet = new HashSet(list);
        return new ArrayList(hashSet);
    }
}
