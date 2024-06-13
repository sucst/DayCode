package cn.atsuc.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author atsuc
 * @date 2024/6/11 21:19
 * @email s202011105851@163.com
 * @description 获取当前运行时类的属性结构
 */
public class FieldTest {

    @Test
    public void FieldTest1() {
        Class personClass = Person.class;
        // 获取属性结构
        // getFields(): 当前运行时类极其父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        // getDeclaredFields() 获取声明的所有属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    @Test
    public void FieldTest2() {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            // 1.权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " \t");

            // 2.数据类型
            Class<?> type = field.getType();
            System.out.println(type.getName() + " " + " \t");

            // 3.变量名
            String name = field.getName();
            System.out.println(name + " \t");

            System.out.println();
        }
    }
}
