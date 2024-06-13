package cn.atsuc.Fanctory.AbstractFactory;

//小米路由器
public class XiaoMiRouter implements RouterProduction{
    @Override
    public void start() {
        System.out.println("小米路由器开启");
    }

    @Override
    public void shutdown() {
        System.out.println("小米路由器关闭");
    }

    @Override
    public void openWiFi() {
        System.out.println("小米WiFi开启");
    }
}
