package cn.atsuc.collection;

import cn.atsuc.collection.vo.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author atsuc
 * @date 2024/6/7 0:40
 * @email s202011105851@163.com
 * @description
 */
public class TreeSetTest {

    /**
        1.向TreeSet中添加的数据，要求是相同类的对象。
        2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）
        3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
        4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
     */
    @Test
    public void treeSetTest01() {
        TreeSet set = new TreeSet();

//        1. failure
//        set.add(123);
//        set.add(456);
//        set.add("AA");  // java.lang.Integer cannot be cast to java.lang.String 不同添加不同类型对象
//        set.add(new Person("Tom", 22));

        // example 01
        set.add(new Person("Jack", 23));
        set.add(new Person("Jack", 24));
        set.add(new Person("Jack", 25));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void treeSetTest02() {

//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Person && o2 instanceof Person) {
//                    Person p1 = (Person) o1;
//                    Person p2 = (Person) o2;
//                    return Integer.compare(p1.getAge(), p2.getAge());
//                } else {
//                    throw new ClassCastException("Error Type Data");
//                }
//            }
//        };

        // lamda 表达式
        Comparator comparator = (o1, o2) -> {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new ClassCastException("Error Type Data");
                }
        };

        TreeSet set = new TreeSet(comparator);
        set.add(new Person("Jack", 23));
        set.add(new Person("kimi", 24));
        set.add(new Person("lisa", 25));
        set.add(new Person("lisa", 5));
        set.add(new Person("alida", 63));
        set.add(new Person("arik", 5));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
