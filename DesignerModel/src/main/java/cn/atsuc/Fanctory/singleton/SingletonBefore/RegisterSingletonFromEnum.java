package cn.atsuc.Fanctory.singleton.SingletonBefore;

/**
 * 注册登记式还有一种写法，枚举型单例
 * 枚举单例
 * 这种形式不能防止反射破坏单例，因为构造器还是暴露在枚举外面
 */
public class RegisterSingletonFromEnum {

    /** 私有化类构造器 */
    private RegisterSingletonFromEnum() {}

    /** 使用 enum 实例特性创建 RegisterSingletonFromEnum 类对象 */
    private enum Singleton {
        INSTANCE;

        private RegisterSingletonFromEnum instance;

        // JVM保证此方法只调用一次
        Singleton() {
            instance = new RegisterSingletonFromEnum();
        }
    }

    /** 提供公共静态的获取该私有类对象的方法
     * @return
     * */
    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }

}


/**
 * 这种方式可以防止反射破坏单例，推荐这个，上面不够准确
 */
class SingletonTest08 {
    public static void main(String[] args) {

        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        //默认构造器，只执行一次
//true
//460141958 每使用一次，都往一个固定的容器中去注册并将使用过的对象进行缓存，
//460141958 下次去取对象的时候，就直接从缓存中取值，以保证每次获取的都是同一个对象
//ok~
        instance.sayOK();
    }
}

//使用枚举，可以实现单例, 推荐
enum Singleton {
    INSTANCE; //属性

    Singleton(){
        //默认构造器，只执行一次
        System.out.println("默认构造器，只执行一次");
    }
    public void sayOK() {
        System.out.println("ok~");
    }
}
