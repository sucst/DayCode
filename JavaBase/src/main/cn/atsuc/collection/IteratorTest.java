package cn.atsuc.collection;

import cn.atsuc.collection.vo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 * 默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *
 * @author atsuc
 * @date 2024/6/4 20:08
 * @email s202011105851@163.com
 * @description
 */
public class IteratorTest {

    @Test
    public void iteratorTest01() {
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        Iterator iterator = coll.iterator();


        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for(int i = 0;i < coll.size();i++){
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        ////hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals(1)) {
                iterator.remove();
            }
        }
        System.out.println(coll);
    }

    @Test
    public void iteratorTest02() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：空指针
        Iterator iterator = coll.iterator();
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：死循环
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }
    }

    @Test
    public void iteratorTest03() {
        //测试Iterator中的remove()
        //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
        // 再调用remove都会报IllegalStateException。
        Collection coll = new ArrayList();
        coll.add(1);
        coll.add(2);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
//            iterator.remove();
            Object object = iterator.next();
            if (object.equals("Tom")) {
                iterator.remove();
            }
        }

        // 遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
