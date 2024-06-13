package cn.atsuc.Fanctory.ChainOfResponsibility;

/**
 * @author csup
 * @creatTime 2024/5/16 9:33
 * @description 采购申请类
 */
public class PurchaseRequest {
    private Integer id;
    private Float price;

    public PurchaseRequest(Integer id, Float price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
