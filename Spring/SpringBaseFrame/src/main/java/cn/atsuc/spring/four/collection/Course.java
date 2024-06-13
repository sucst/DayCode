package cn.atsuc.spring.four.collection;

/**
 * @author csuporg
 * @data 2024/5/7 23:48
 * @email s202011105851@163.com
 * @description
 */
public class Course {
    private String cname;
    public void setCname (String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
