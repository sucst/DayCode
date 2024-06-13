package cn.atsuc.reflect;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author atsuc
 * @date 2024/6/11 20:48
 * @email s202011105851@163.com
 * @description 反射测试
 */
public class ReflectionTest {
    // operation Person
    @Test
    public void ReflectionTest1() {
        Person jack = new Person("Jack", 18);
        jack.age = 12;
        System.out.println(jack.toString());

        jack.show();
        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }

    @Test
    public void ReflectionTest2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor =
                clazz.getConstructor(String.class, int.class);
        Person jack = constructor.newInstance("Jack", 12);
        System.out.println(jack.toString());
        // 通过反射，调用对象指定的属性方法
        Field age = clazz.getDeclaredField("age");
        age.set(jack, 10);
        System.out.println(jack.toString());

        // 调用方法
        clazz.getDeclaredMethod("show").invoke(jack);
        System.out.println("=================================");

        // 通过反射可以调用Person的私有结构
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person marry = declaredConstructor.newInstance("marry");
        System.out.println(marry.toString());

        // 私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object nation = showNation.invoke(marry, "china");
        System.out.println(nation.toString());
    }

    //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
    //建议：直接new的方式。 反射会破坏封装，必要是才使用
    //什么时候会使用：反射的方式。 反射的特征：动态性
    //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾。

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void ReflectionTest3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz = Person.class;
        System.out.println(clazz);
        //方式二：通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> aClass1 = Class.forName("cn.atsuc.reflect.Person");
        System.out.println(aClass1);

        System.out.println(clazz == aClass);
        System.out.println(clazz == aClass1);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("cn.atsuc.reflect.Person");
        System.out.println(aClass2);

        System.out.println(clazz == aClass2);
    }

    // Class实例可以是哪些结构的说明：
    @Test
    public void ReflectionTest4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

    @Test
    public void ReflectionTest5() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class clazz = PersonAnnotation.class;
        //创建运行时类的对象
        PersonAnnotation p = (PersonAnnotation) clazz.newInstance();
        //获取指定的属性：要求运行时类中属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");
        /*
            设置当前属性的值
            set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
         */
        id.set(p,1001);
        /*
            获取当前属性的值
            get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }
    /*
        如何操作运行时类中的指定的属性 -- 需要掌握
     */
    @Test
    public void ReflectionTest6() throws Exception {
        Class clazz = PersonAnnotation.class;
        //创建运行时类的对象
        PersonAnnotation p = (PersonAnnotation) clazz.newInstance();
        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }
    /*
       如何操作运行时类中的指定的方法 -- 需要掌握
    */
    @Test
    public void ReflectionTest7() throws Exception {
        Class clazz = PersonAnnotation.class;

        //创建运行时类的对象
        PersonAnnotation p = (PersonAnnotation) clazz.newInstance();

        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        show.setAccessible(true);

        /*
        3. 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object returnValue = show.invoke(p,"CHN"); //String nation = p.show("CHN");
        System.out.println(returnValue);

        System.out.println("*************如何调用静态方法*****************");

        // private static void showDesc()

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
//        Object returnVal = showDesc.invoke(null);
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);//null

    }

     /*
        如何调用运行时类中的指定的构造器
     */
    @Test
    public void ReflectionTest8() throws Exception {
        Class clazz = PersonAnnotation.class;
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object tom = declaredConstructor.newInstance("Tom");
        System.out.println(tom);
    }

}
