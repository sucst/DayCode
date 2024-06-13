package cn.atsuc.spring.autowire;

/**
 * @author csuporg
 * @data 2024/5/7 22:14
 * @email s202011105851@163.com
 * @description
 */

// 员工类
public class Emp {

    private String eName;
    private String gender;
     public void seteName(String eName) {
        this.eName = eName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void outPut() {
        System.out.println("Emp{" +
                "eName='" + eName + '\'' +
                ", gender='" + gender + '\'' +
                '}');
    }
}
