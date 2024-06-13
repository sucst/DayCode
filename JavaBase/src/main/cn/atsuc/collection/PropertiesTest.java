package cn.atsuc.collection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author atsuc
 * @date 2024/6/9 9:14
 * @email s202011105851@163.com
 * @description
 */
public class PropertiesTest {
    @Test
    public void test() throws IOException {
        Properties p = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/resources/jdbc.properties");
        p.load(inputStream); //加载流对应的文件

        String name = p.getProperty("jdbc.name");
        System.out.println(name);
    }
}
