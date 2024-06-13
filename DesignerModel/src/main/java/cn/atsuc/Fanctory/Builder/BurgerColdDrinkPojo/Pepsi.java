package cn.atsuc.Fanctory.Builder.BurgerColdDrinkPojo;


// 雪碧 Pepsi.java

import cn.atsuc.Fanctory.Builder.ColdDrink;

public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
