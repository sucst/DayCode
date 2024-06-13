package cn.atsuc.Fanctory.RealFanctory;

/**
 * 这里这样设计的好处，就是如果需要加新产品，只需要新增工厂实现类就行了，不需要去改原来的代码了。
 * 这就易于扩展，解决了简单工厂的缺点。缺点就是代码量也变多了。
 */

public class Test {
    public static void main(String[] args) {
        Car BMVcar = new BMWCarFactory().CreateCar();
        Car Lrcar = new LandRoverCarFactory().CreateCar();

        BMVcar.run();
        Lrcar.run();
    }
}
