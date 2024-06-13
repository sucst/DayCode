package cn.atsuc.Fanctory.AbstractFactory;

public interface Factory {
    //生产手机
    PhoneProduction createPhone();

    //生产路由器
    RouterProduction createRouter();
}
