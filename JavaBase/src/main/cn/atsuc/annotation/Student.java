package cn.atsuc.annotation;

/**
 * @author atsuc
 * @date 2024/6/7 8:18
 * @email s202011105851@163.com
 * @description
 */
public class Student extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public void show() {

    }
}
