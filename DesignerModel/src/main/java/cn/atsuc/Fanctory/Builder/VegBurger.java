package cn.atsuc.Fanctory.Builder;

// 素食汉堡 VegBurger.java

public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
