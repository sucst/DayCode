package cn.atsuc.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author atsuc
 * @date 2024/6/4 0:02
 * @email s202011105851@163.com
 * @description
 */
public class GoodTest {

    public static void main(String[] args) {
        Goods[] goods = new Goods[4];
        goods[1] = new Goods("《红楼梦》", 99.4);
        goods[2] = new Goods("《水浒传》", 12.4);
        goods[3] = new Goods("《三国》", 54.0);
        goods[0] = new Goods("《西游》", 974.0);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

        // 定制排序
       Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                return g1.getName().compareTo(g2.getName());
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
