package cn.atsuc.Fanctory.AbstractFactory;

//华为手机
public class HuaWeiPhone implements PhoneProduction {
    @Override
    public void start() {
        System.out.println("华为手机开启");
    }

    @Override
    public void shutdown() {
        System.out.println("华为手机关闭");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendMSS() {
        System.out.println("华为手机发短信");
    }
}
