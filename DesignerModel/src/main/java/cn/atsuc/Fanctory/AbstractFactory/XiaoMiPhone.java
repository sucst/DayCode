package cn.atsuc.Fanctory.AbstractFactory;

public class XiaoMiPhone implements PhoneProduction{
    @Override
    public void start() {
        System.out.println("小米手机开启");
    }

    @Override
    public void shutdown() {
        System.out.println("小米手机关闭");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendMSS() {
        System.out.println("小米手机发短信");
    }
}

