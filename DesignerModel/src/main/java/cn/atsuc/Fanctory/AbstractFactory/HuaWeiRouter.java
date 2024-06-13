package cn.atsuc.Fanctory.AbstractFactory;

//华为路由器
public class HuaWeiRouter implements RouterProduction{
    @Override
    public void start() {
        System.out.println("华为路由器开启");
    }

    @Override
    public void shutdown() {
        System.out.println("华为路由器关闭");
    }

    @Override
    public void openWiFi() {
        System.out.println("华为WiFi开启");
    }
}
