package cn.atsuc.Fanctory.singleton.SingletonBefore;

/**
 * 懒汉式，相比于饿汉式，它是指JVM首次访问到该单例类时，并不会实例化该单例类对象，只有等到后续被外部调用时，才会实例化该单例类对象。
 * 饿汉式的写法比较固定，懒汉式由于延时加载的特性，写法上有一些变化，一般来说，懒汉式存在4个变种。
 *
 *懒汉式——无锁，线程不安全
 * 优点:
 *     由于懒汉式延时加载特性，使用该实例时才实例化，节省了内存资源
 *
 * 缺点:
 *     (1) 该种实现方式存在线程不安全问题
 *     (2) 反序列化，反射与克隆可破坏单例
 *
 *    这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁    	  synchronized，所以严格意义上它并不算单例模式。
 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class LazySingletonWithoutSync {
    /** 私有化类构造器 */
    private LazySingletonWithoutSync() {}

    /** 定义静态私有类对象 */
    private static LazySingletonWithoutSync instance;

    /** 提供公共静态的获取该私有类对象的方法 */
    public static LazySingletonWithoutSync getInstance() {
        if (instance == null) {
            instance = new LazySingletonWithoutSync();
        }

        return instance;
    }
}



