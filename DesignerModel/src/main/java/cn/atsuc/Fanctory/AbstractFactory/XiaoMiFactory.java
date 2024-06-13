package cn.atsuc.Fanctory.AbstractFactory;

public class XiaoMiFactory implements Factory{
    @Override
    public PhoneProduction createPhone() {
        return new XiaoMiPhone();
    }

    @Override
    public RouterProduction createRouter() {
        return new XiaoMiRouter();
    }
}
