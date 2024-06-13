package cn.atsuc.Fanctory.RealFanctory;

public class LandRoverCarFactory implements CarFactory{
    @Override
    public Car CreateCar() {
        return new LandRoverCar();
    }
}
