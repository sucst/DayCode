package cn.atsuc.Fanctory.Builder;

// 汉堡抽象类 Burger.java

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();   //注意这里是一个包装类
    }

    @Override
    public abstract float price();
}