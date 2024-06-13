package cn.atsuc.Fanctory.Builder;

import java.util.ArrayList;
import java.util.List;

//套餐 Meal.java
public class Meal {
    private List<Item> items = new ArrayList<Item>();
    //套餐增加食物
    public void addItem(Item item){
        items.add(item);
    }
    //获取套餐总价格
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }
    //打印套餐信息
    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            //item.packing()返回的是packing 类对象
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
