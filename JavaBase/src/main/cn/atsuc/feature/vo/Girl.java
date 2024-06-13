package cn.atsuc.feature.vo;

/**
 * @author atsuc
 * @date 2024/6/12 8:23
 * @email s202011105851@163.com
 * @description
 */
public class Girl {
    private String name;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl() {

    }

    public Girl(String name) {

        this.name = name;
    }
}
