package cn.atsuc.Fanctory.RealFanctory;

public class BMWCarFactory implements CarFactory{
    @Override
    public Car CreateCar() {
        return new BMWCar();
    }
}
