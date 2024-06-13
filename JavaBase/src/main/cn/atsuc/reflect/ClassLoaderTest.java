package cn.atsuc.reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author atsuc
 * @date 2024/6/11 20:24
 * @email s202011105851@163.com
 * @description 了解类加载器
 */
public class ClassLoaderTest {
    @Test
    public void ClassLoaderTest1() {
        // 对于自定义类，使用系统类加载起进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader : "+classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 调用系统类加载器的getParent()；获取扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println("classLoaderParent : "+classLoaderParent); // sun.misc.Launcher$ExtClassLoader@28a418fc
        // 调用扩展嘞加载器的getParent();无法获取引导类加载器
        // 引导类加载器主要负责加载Java的核心库，无法加载自定义的类
        ClassLoader classLoaderParentParent = classLoaderParent.getParent();
        System.out.println("classLoaderParentParent : "+classLoaderParentParent); // null

        ClassLoader classLoaderChild = String.class.getClassLoader();
        System.out.println("classLoaderChild : "+classLoaderChild); // null
    }

    @Test
    public void ClassLoaderPropertiesTest2() throws IOException {
        Properties properties = new Properties();
        // 此时的文件默认在当前module
        // 读取文件配置方式一:
//        FileInputStream inputStream = new FileInputStream("D:\\code\\github\\DayilyCode\\JavaBase\\src\\main\\java\\cn\\atsuc\\reflect\\jdbc1.properties");
//        FileInputStream fis = new FileInputStream("src\\main\\java\\cn\\atsuc\\reflect\\jdbc1.properties");
//        properties.load(inputStream);
//        System.out.println(fis);
        // 方式二: 使用ClassLoader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties"); // 只能是当前module下，其他不行加路径;
        if (is != null) {
            properties.load(is);
        }
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user : "+user+ " password : "+password);

//        inputStream.close();
//        fis.close();
    }
}
