package cn.atsuc.annotation;

/**
 * @author atsuc
 * @date 2024/6/7 8:17
 * @email s202011105851@163.com
 * @description
 * jdk 8之前的写法：
 * @MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
 */
@MyAnnotation(value = "hi")
@MyAnnotation(value = "atsuc")
public class Person{
    private String name;
    private int age;

    public Person() {
    }
    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
