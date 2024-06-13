package cn.atsuc.Fanctory.Builder;


// 雪碧 Pepsi.java

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
