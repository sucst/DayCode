package cn.atsuc.spring.startProperity;

/**
 * @author csuporg
 * @data 2024/5/8 19:32
 * @email s202011105851@163.com
 * @description
 */
public class Order {

    private String Oname;

    public Order() {
        System.out.println("第一步 : 执行无参构造函数创建bean实例 ");
    }

    public void setOname(String oname) {
        System.out.println("第二步 : 调用set方法设置属性值 ");
        this.Oname = oname;
    }

    public void initMethos() {
        System.out.println("第三步 : 执行初始化方法 ");
    }

    public void destoryMethod() {
        System.out.println("第五步 : 销毁对象");
    }
}
