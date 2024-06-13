package cn.atsuc.reflect;

import cn.atsuc.annotation.MyAnnotation;

/**
 * @author atsuc
 * @date 2024/6/11 23:38
 * @email s202011105851@163.com
 * @description
 */
@MyAnnotation(value = "hi")
public class PersonAnnotation extends Creature<String> implements Comparable<String>, MyInterface{
    private String name;
    int age;
    public int id;

    public PersonAnnotation(){}

    @MyAnnotation(value="abc")
    private PersonAnnotation(String name){
        this.name = name;
    }

    PersonAnnotation(String name,int age){
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests,int age) throws NullPointerException,ClassCastException{
        return interests + age;
    }


    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
