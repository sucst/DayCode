package cn.atsuc.compare;

/**
 * @author atsuc
 * @date 2024/6/3 23:55
 * @email s202011105851@163.com
 * @description
 */

public class Goods implements Comparable {

    private String name;
    private Double price;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods g = (Goods) o;
            if (this.price > g.price) {
                return 1;
            } else if (this.price < g.price) {
                return -1;
            }
            return 0;
        }
        throw new RuntimeException(" 输入类型不一致");
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
