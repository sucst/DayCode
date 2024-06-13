package cn.atsuc.Fanctory.Builder;

//冷饮抽象类 ColdDrink.java

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();  //注意这里是一个包装类
    }

    @Override
    public abstract float price();
}
