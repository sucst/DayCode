package cn.atsuc.Fanctory.Builder;


// 鸡肉汉堡 ChickenBurger.java

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
