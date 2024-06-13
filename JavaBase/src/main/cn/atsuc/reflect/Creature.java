package cn.atsuc.reflect;

import java.io.Serializable;

/**
 * @author atsuc
 * @date 2024/6/11 23:38
 * @email s202011105851@163.com
 * @description
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}
