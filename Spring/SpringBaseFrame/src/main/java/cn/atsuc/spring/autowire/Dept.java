package cn.atsuc.spring.autowire;

/**
 * @author csuporg
 * @data 2024/5/7 22:13
 * @email s202011105851@163.com
 * @description
 */
public class Dept {

    private String dName;

    public void setdName(String dName) {
        this.dName = dName;
    }
    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                '}';
    }
}
