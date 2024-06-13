package cn.atsuc.Fanctory.AbstractFactory;

public class HuaWeiFactory implements Factory{
    @Override
    public PhoneProduction createPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public RouterProduction createRouter() {
        return new HuaWeiRouter();
    }
}
