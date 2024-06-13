package cn.atsuc.spring.one.Vo;

/**
 * @author csuporg
 * @data 2024/5/7 19:48
 * @email s202011105851@163.com
 * @description
 */
public class Orders {

    private String OName;
    private String Address;

    public Orders(String OName, String address) {
        this.OName = OName;
        this.Address = address;
    }

    public void testOrders(){
        System.out.println(OName + Address);
    }

}
