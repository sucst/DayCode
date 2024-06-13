package cn.atsuc.Fanctory.singleton.SingletonBefore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 每使用一次，都往一个固定的容器中去注册并将使用过的对象进行缓存，
 * 下次去取对象的时候，就直接从缓存中取值，以保证每次获取的都是同一个对象。
 * Spring IOC中的单例模式，就是典型的注册登记式单例。
 *
 * 注册登记式——map容器单例
 */
public class RegisterSingletonFromMap {

    /** 私有化类构造器 */
    private RegisterSingletonFromMap() {}

    /** 使用 ConcurrentHashMap 容器，装载 RegisterSingletonFromMap 类对象 */
    private static Map<String, RegisterSingletonFromMap> map = new ConcurrentHashMap<String, RegisterSingletonFromMap>();

    /** 提供公共静态的获取该私有类对象的方法 */
    public static RegisterSingletonFromMap getInstance() {
        String className = RegisterSingletonFromMap.class.getName();

        synchronized (RegisterSingletonFromMap.class) {
            if (!map.containsKey(className)) {
                //ConcurrentMap提供线程安全和原子性保证
                map.put(className, new RegisterSingletonFromMap());
            }
        }

        return map.get(className);
    }

}
