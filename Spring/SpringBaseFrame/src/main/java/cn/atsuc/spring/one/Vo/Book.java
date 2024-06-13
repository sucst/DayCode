package cn.atsuc.spring.one.Vo;

/**
 * @author csuporg
 * @data 2024/5/7 19:46
 * @email s202011105851@163.com
 * @description
 */
public class Book {
    private String BName;
    private String BAuthor;

    public void setBName(String BName) {
        this.BName = BName;
    }
    public void setBAuthor(String BAuthor) {
        this.BAuthor = BAuthor;
    }

    public void testBook(){
        System.out.println(BName + BAuthor);
    }
}
