package cn.atsuc.Fanctory.Builder.BurgerColdDrinkPojo;


// 鸡肉汉堡 ChickenBurger.java

import cn.atsuc.Fanctory.Builder.Burger;

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
