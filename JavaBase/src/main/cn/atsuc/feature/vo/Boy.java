package cn.atsuc.feature.vo;

/**
 * @author atsuc
 * @date 2024/6/12 8:24
 * @email s202011105851@163.com
 * @description
 */
public class Boy {
    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy() {

    }

    public Boy(Girl girl) {

        this.girl = girl;
    }
}
