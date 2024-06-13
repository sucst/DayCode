package cn.atsuc.file.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author atsuc
 * @date 2024/6/9 22:10
 * @email s202011105851@163.com
 * @description
 */
public class SubOrder extends Order<Integer> {
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}
