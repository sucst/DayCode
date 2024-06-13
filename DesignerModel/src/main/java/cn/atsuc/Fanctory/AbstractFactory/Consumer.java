package cn.atsuc.Fanctory.AbstractFactory;

public class Consumer {
    public static void main(String[] args) {
        System.out.println("---------小米产品----------");
        PhoneProduction xiaomi = new XiaoMiFactory().createPhone();
        RouterProduction xiaomirouter = new XiaoMiFactory().createRouter();
        xiaomi.call();
        xiaomi.sendMSS();
        xiaomi.shutdown();
        xiaomirouter.openWiFi();
        xiaomirouter.shutdown();
        System.out.println("---------华为产品----------");
        PhoneProduction Huawei = new HuaWeiFactory().createPhone();
        RouterProduction huaweirouter = new HuaWeiFactory().createRouter();
        Huawei.call();
        Huawei.sendMSS();
        Huawei.shutdown();
        huaweirouter.openWiFi();
        huaweirouter.shutdown();
    }
}
