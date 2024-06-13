package cn.atsuc.Fanctory.singleton.SingletonBefore;

/**
 * 饿汉式，顾名思义，就是指在JVM首次访问到该单例类时，就会把该单例类对象创建出来，并保存在内存中，不管后续是否会使用到这个单例。
 *
 *优点：
 *     (1) 没有加任何的锁，执行效率较高
 *     (2) 线程安全
 * 缺点：
 *    (1) 类加载的时候就进行了初始化，程序后续未必会使用到该实例，导致内存浪费
 *    (2) 反射可破坏单例
 */
public class HungrySingleton {

    /** 私有化类构造器 */
    private HungrySingleton() {}

    /** 定义静态私有类对象 */
    private static HungrySingleton instance = new HungrySingleton();

    /** 提供公共静态的获取该私有类对象的方法 */
    public static HungrySingleton getInstance() {
        return instance;
    }
}
