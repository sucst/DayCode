package cn.atsuc.Fanctory.SimpleFan;

public class CarFactory {

    public static Car createBMCar()
    {
        return new BMWCar();

    }

    public static Car createLandRoverCar()
    {
        return new LandRoverCar();

    }
}
