package cn.atsuc.Fanctory.SimpleFan;

/**
 * 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。但是同时简单工厂存在于这几个缺点。
 *
 * 缺点：
 *
 * 工厂类集中了所有实例（产品）的创建逻辑，一旦这个工厂不能正常工作，整个系统都会受到影响；
 * 违背“开放 - 关闭原则”，一旦添加新产品就不得不修改工厂类的逻辑，这样就会造成工厂逻辑过于复杂
 * 简单工厂模式由于使用了静态工厂方法，静态方法不能被继承和重写，会造成工厂角色无法形成基于继承的等级结构。
 */

public class Test {
    public static void main(String[] args) {
        Car bmCar = CarFactory.createBMCar();
        bmCar.run();

        Car landRoverCar = CarFactory.createLandRoverCar();
        landRoverCar.run();
    }
}
