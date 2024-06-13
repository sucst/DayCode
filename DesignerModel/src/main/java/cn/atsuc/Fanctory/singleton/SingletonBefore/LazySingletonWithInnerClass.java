package cn.atsuc.Fanctory.singleton.SingletonBefore;

/**
 * 使用解释 : 静态内部类和非静态内部类一样，都是在被调用时才会被加载，以此来实现懒汉模式。
 * 所用环境，在单例对象占用资源大，需要延时加载的情况下优选。
 *
 *
 *
 * 懒汉式——静态内部类单例
 * 优点:
 *     (1) 由于懒汉式延时加载特性，使用该实例时才实例化，节省了内存资源
 *     (2) 在外部类 getInstance 方法被调用的时候内部类才会被加载，巧妙地避免了线程安全问题
 *     (3) 兼顾了synchronized的性能问题
 *
 * 缺点:
 *     反序列化，反射与克隆可破坏单例
 */
public class LazySingletonWithInnerClass {

    /** 私有化类构造器 */
    private LazySingletonWithInnerClass() {}

    /** 使用内部类定义静态私有 LazySingletonWithInnerClass 类对象 */
    private static class LazyHolder {
        private static final LazySingletonWithInnerClass INSTANCE = new LazySingletonWithInnerClass();
    }

    /** 提供公共静态的获取该私有类对象的方法 */
    public static LazySingletonWithInnerClass getInstance() {
        return LazyHolder.INSTANCE;
    }

}
