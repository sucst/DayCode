package cn.atsuc.collection;

import cn.atsuc.collection.vo.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author atsuc
 * @date 2024/6/4 22:36
 * @email s202011105851@163.com
 * @description
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 *
 */
public class CollectionTest {
   @Test
   public void test() {
      ArrayList<String> list = new ArrayList<>();
      //static <T> boolean addAll(Collection<? super T> c, T... elements)->批量添加元素
      Collections.addAll(list,"张三","李四","王五","赵六","田七","朱八");
      System.out.println(list);
      //static void shuffle(List<?> list) ->将集合中的元素顺序打乱
      Collections.shuffle(list);
      System.out.println(list);
      //static <T> void sort(List<T> list) ->将集合中的元素按照默认规则排序-> ASCII码表
      ArrayList<String> list1 = new ArrayList<>();
      list1.add("c.举头望明月");
      list1.add("a.床前明月光");
      list1.add("d.低头思故乡");
      list1.add("b.疑是地上霜");
      Collections.sort(list1);
      System.out.println(list1);
   }

   @Test
   public void test2() {
      ArrayList<Person> list = new ArrayList<>();
      list.add(new Person("柳岩",18, "18-230"));
      list.add(new Person("涛哥",16, "16-340"));
      list.add(new Person("金莲",20, "20-560"));
      list.add(new Person("大圣",20, "20-559"));

      Collections.sort(list, new Comparator<Person>() {
         @Override
         public int compare(Person o1, Person o2) {
            String code = o1.getCode();
            String code2 = o2.getCode();
            String[] replace = code.split("-");
            String[] replace2 = code2.split("-");
            int compare = Integer.compare(Integer.parseInt(replace[0]), Integer.parseInt(replace2[0])); // 比较第一个部分
            if (compare != 0) {
               return compare;
            }
            // 第二个部分
            return replace[1].compareTo(replace2[1]);
         }
      });
      System.out.println(list);
   }

   @Test
   public void test3() {
      HashMap<Person, String> map = new HashMap<>();
      map.put(new Person("涛哥",18, "34-775"),"河北省");
      map.put(new Person("三上",26, "18-3453"),"日本");
      map.put(new Person("涛哥",18, "34-775"),"北京市");
      System.out.println(map);
      // 自定义去重结果:
      // {Person{name='涛哥', age=18', code='34-775}=北京市, Person{name='三上', age=26', code='18-3453}=日本}
      // 不定义
      // {Person{name='涛哥', age=18', code='34-775}=河北省, Person{name='涛哥', age=18', code='34-775}=北京市, Person{name='三上', age=26', code='18-3453}=日本}
   }

   /**
    需求:用Map集合统计字符串中每一个字符出现的次数
    步骤:
    1.创建Scanner和HashMap
    2.遍历字符串,将每一个字符获取出来
    3.判断,map中是否包含遍历出来的字符 -> containsKey
    4.如果不包含,证明此字符第一次出现,直接将此字符和1存储到map中
    5.如果包含,根据字符获取对应的value,让value++
    6.将此字符和改变后的value重新保存到map集合中
    7.输出
    */
   @Test
   public void test4() {
      //1.创建Scanner和HashMap
      Scanner sc = new Scanner(System.in);
      HashMap<String, Integer> map = new HashMap<>();
      map.put("name", 1);
      String data = sc.next();
      //2.遍历字符串,将每一个字符获取出来
      char[] charArray = data.toCharArray();
      for (char charKey : charArray) {
         String key = charKey + "";
         // 3.判断,map中是否包含遍历出来的字符 -> containsKey
         if (!map.containsKey(key)) {
            // 4.如果不包含,证明此字符第一次出现,直接将此字符和1存储到map中
             map.put(key, 1);
         } else {
            // 5.如果包含,根据字符获取对应的value,让value++
            // 6.将此字符和改变后的value重新保存到map集合中
            map.put(key, map.get(key) + 1);
         }
      } // for
      // 输出
      System.out.println(map);
   }

   @Test
   public void test5() {
      //1.创建数组-> color -> 专门存花色
      String[] color = "♠-♥-♣-♦".split("-");
      //2.创建数组 -> number -> 专门存牌号
      String[] number = "2-3-4-5-6-7-8-9-10-J-Q-K-A".split("-");
      //3.创建map集合,key为序号,value为组合好的牌面
      HashMap<Integer, String> poker = new HashMap<>();
      //4.创建一个ArrayList,专门存储key
      ArrayList<Integer> list = new ArrayList<>();
      list.add(0);
      list.add(1);

      //5.组合牌,存储到map中
      int key = 2;
      for (String num : number) {
         for (String huaSe : color) {
            String pokerNumber = huaSe+num;
            poker.put(key,pokerNumber);
            list.add(key);
            key++;
         }
      }

      poker.put(0,"😊");
      poker.put(1,"☺");

      //6.洗牌,打乱list集合中的key
      Collections.shuffle(list);
      //7.创建四个list集合
      ArrayList<Integer> p1 = new ArrayList<>();
      ArrayList<Integer> p2 = new ArrayList<>();
      ArrayList<Integer> p3 = new ArrayList<>();
      ArrayList<Integer> dipai = new ArrayList<>();

      //8.发牌
      for (int i = 0; i < list.size(); i++) {
         Integer key1 = list.get(i);
         if (i>=51){
            dipai.add(key1);
         }else if (i%3==0){
            p1.add(key1);
         }else if (i%3==1){
            p2.add(key1);
         }else if (i%3==2){
            p3.add(key1);
         }
      }

      //9.排序
      Collections.sort(p1);
      Collections.sort(p2);
      Collections.sort(p3);
      Collections.sort(dipai);

      lookPoker("涛哥",p1,poker);
      lookPoker("三上",p2,poker);
      lookPoker("金莲",p3,poker);
      lookPoker("大郎",dipai,poker);
   }
   private static void lookPoker(String name, ArrayList<Integer> list, HashMap<Integer, String> map) {
      System.out.print(name+":");

      for (Integer key : list) {
         String value = map.get(key);
         System.out.print(value+" ");
      }

      System.out.println();
   }

   @Test
   public void test6() {
      Collection coll = new ArrayList();

      //add(Object e):将元素e添加到集合coll中
      coll.add("AA");
      coll.add("BB");
      coll.add(123);//自动装箱
      coll.add(new Date());

      //size():获取添加的元素的个数
      System.out.println(coll.size());//4

      //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
      Collection coll1 = new ArrayList();
      coll1.add(456);
      coll1.add("CC");
      coll.addAll(coll1);

      System.out.println(coll.size());//6
      System.out.println(coll);

      //clear():清空集合元素
      coll.clear();

      //isEmpty():判断当前集合是否为空
      System.out.println(coll.isEmpty());

   }
  /**
   reverse(List)：反转 List 中元素的顺序
   shuffle(List)：对 List 集合元素进行随机排序
   sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
   sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
   swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

   Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
   Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
   Object min(Collection)
   Object min(Collection，Comparator)
   int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
   void copy(List dest,List src)：将src中的内容复制到dest中
   boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
 */
   @Test
   public void test7() {
      List list = new ArrayList<>();
      list.add(123);
      list.add(456);
      list.add(153f);
      list.add(-97);
      list.add(0);
// public static <T> void copy(List<? super T> dest, List<? extends T> src) dest:新容器， src:目标容器
//      ArrayList dest = new ArrayList();
//      Collections.copy(dest, list);  //java.lang.IndexOutOfBoundsException: Source does not fit in dest ；因为dest大小小于目标地址
//      System.out.println(dest);


      List<Object> dest = Arrays.asList(new Object[list.size()]);
      System.out.println(dest);

      Collections.copy(dest, list);
      System.out.println("dest : "+dest);
      /**
        Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，从而可以解决
        多线程并发访问集合时的线程安全问题
       */
      //返回的list1即为线程安全的List
      Collections.synchronizedList(list); // 线程安全
      System.out.println("synchronizedList: "+list);
   }

   @Test
   public void test8() {
      List list = new ArrayList();
      list.add(123);
      list.add(43);
      list.add(765);
      list.add(765);
      list.add(765);
      list.add(-97);
      list.add(0);

      System.out.println(list);

      Collections.reverse(list);
      System.out.println("reverse: "+list);

      Collections.shuffle(list);
      System.out.println("shuffle: "+list);

      Collections.sort(list); // 倒序小->大
      System.out.println("reverse sequence sort: "+list);
      Collections.reverse(list);// 大->小
      System.out.println("positive sequence sort: "+list);

      Collections.swap(list,2,3);
      System.out.println("swap: "+list);

      int frequency = Collections.frequency(list, 765);// 频率
      System.out.println("frequency : "+frequency);
   }


}
