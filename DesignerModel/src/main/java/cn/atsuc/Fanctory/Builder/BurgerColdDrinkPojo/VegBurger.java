package cn.atsuc.Fanctory.Builder.BurgerColdDrinkPojo;

// 素食汉堡 VegBurger.java

import cn.atsuc.Fanctory.Builder.Burger;

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
