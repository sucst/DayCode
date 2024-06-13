package cn.atsuc.annotation;

import java.util.ArrayList;

/**
 * @author atsuc
 * @date 2024/6/7 8:20
 * @email s202011105851@163.com
 * @description
 */
public class Generic<@MyAnnotation T> {
    public void show() {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}
