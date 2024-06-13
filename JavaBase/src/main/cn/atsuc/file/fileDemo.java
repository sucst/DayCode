package cn.atsuc.file;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

/**
 * @author atsuc
 * @date 2024/6/9 19:50
 * @email s202011105851@163.com
 * @description 文件方法测试
 * File类的使用
 *
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 */
public class fileDemo {
    @Test
    public void test() throws IOException {
        File file = new File("C:\\Users\\s2020\\Desktop\\file.txt");
        File destFile = new File(file.getParent(), "helloFileDemo.txt");
        file.createNewFile();
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("success");
        }
    }

    // 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    @Test
    public void test1() {
        File file = new File("C:\\Users\\s2020\\Desktop");
        String[] fileList = file.list();
//        for (int i = 0; i < fileList.length; i++) {
//            if (fileList[i].endsWith(".png")) {
//                System.out.println(fileList[i]);
//            }
//        }
        File[] listFiles = file.listFiles();
        for (File file1 : listFiles) {
            if (file1.getName().endsWith(".png")) {
                System.out.println(file1.getAbsolutePath());
            }
        }
    }

    /*
     * File类提供了两个文件过滤器方法
     * public String[] list(FilenameFilter filter)
     * public File[] listFiles(FileFilter filter)
     */
    @Test
    public void test2() {
        File file = new File("C:\\Users\\s2020\\Desktop");
        File[] subFiles = file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".png");
            }
        });
        for (File file1 : subFiles) {
            System.out.println(file1.getAbsolutePath());
        }
    }

    /**
     * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
     拓展1：并计算指定目录占用空间的大小
     拓展2：删除指定文件目录及其下的所有文件
     */

    @Test
    public void test3() {
        // 递归:文件目录
        /** 打印出指定目录所有文件名称，包括子文件目录中的文件 */
        // 1.创建目录对象
        File dir = new File("C:\\Users\\s2020\\Desktop\\programme\\yubi");
        // 2.打印目录的子文件
//        printSubFile(dir);
        //
//        listSubFiles(dir);
//        listAllSubFiles(dir);
        getDirectorySize(dir);

    }

    public static void printSubFile(File dir) {
        // 打印目录的子文件
        File[] subfiles = dir.listFiles();
        for (File f : subfiles) {
            if (f.isDirectory()) { // 文件目录
                printSubFile(f);
            } else { // 文件
                System.out.println(f.getAbsolutePath());
            }
        }
    }
    // 方式二：循环实现
    // 列出file目录的下级内容，仅列出一级的话
    // 使用File类的String[] list()比较简单
    public void listSubFiles(File file) {
        if (file.isDirectory()) {
            String[] all = file.list();
            for (String s : all) {
                System.out.println(s);
            }
        } else {
            System.out.println(file + "是文件！");
        }
    }
    // 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
    // 建议使用File类的File[] listFiles()
    public void listAllSubFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            File[] all = file.listFiles();
            // 如果all[i]是文件，直接打印
            // 如果all[i]是目录，接着再获取它的下一级
            for (File f : all) {
                listAllSubFiles(f);// 递归调用：自己调用自己就叫递归
            }
        }
    }

    // 拓展1：求指定目录所在空间的大小
    // 求任意一个目录的总大小
    public long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] all = file.listFiles();// 获取file的下一级
            // 累加all[i]的大小
            for (File f : all) {
                size += getDirectorySize(f);// f的大小;
            }
        }
        return size;
    }

    // 拓展2：删除指定的目录
    public void deleteDirectory(File file) {
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级干掉，然后删除自己
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : all) {// f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
        file.delete();
    }

    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)
    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
     windows:\\
     unix:/
     */
    @Test
    public void testPath() {
        File file1 = new File("helloFileDemo.txt"); // equals local module
        File file2 = new File("C:\\Users\\s2020\\Desktop\\demo.txt");
        System.out.println(file1);
        System.out.println(file2);

        // constructor
        File file3 = new File("C:\\Users\\s2020", "Desktop");
        System.out.println(file3);

        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }
    /*
    public String getAbsolutePath()：获取绝对路径
    public String getPath() ：获取路径
    public String getName() ：获取名称
    public String getParent()：获取上层文件目录路径。若无，返回null
    public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
    public long lastModified() ：获取最后一次的修改时间，毫秒值

    如下的两个方法适用于文件目录：
    public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
    * */
    @Test
    public void testMethod() {
        File file = new File("C:\\Users\\s2020\\Desktop");
        File file1 = new File("C:\\Users\\s2020\\Desktop\\hello.txt");
        File file2 = new File("C:\\Users\\s2020\\Desktop\\programme\\yubi");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        String[] list = file2.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
        File[] listFiles = file2.listFiles();
        for (File f : listFiles) {
            System.out.println(f);
        }
    }
    /*
   public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)为例：
       要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
    */
    @Test
    public void testReName() throws IOException {
        File file = new File("hello.txt"); // 在当前目录下
        File file1 = new File("C:\\Users\\s2020\\Desktop\\hellorename.txt");

        boolean rename = file1.renameTo(file); // 替换之后，被替换的消失，移动到希望替换的位置，此处为：file1 消失， 生成file,前提file1存在
        System.out.println(rename);
        System.out.println(file.getAbsolutePath());
    }

    /*
        public boolean isDirectory()：判断是否是文件目录
        public boolean isFile() ：判断是否是文件
        public boolean exists() ：判断是否存在
        public boolean canRead() ：判断是否可读
        public boolean canWrite() ：判断是否可写
        public boolean isHidden() ：判断是否隐藏
    */
    @Test
    public void testMethod1() {
        File file = new File("D:\\code\\github\\DayilyCode\\JavaBase\\hello.txt");

        System.out.printf("\n file.isDirectory() : %b ", file.isDirectory());
        System.out.printf("\n file.isFile() : %b ", file.isFile());
        System.out.printf("\n file.exists() : %b ", file.exists());
        System.out.printf("\n file.canRead() : %b ", file.canRead());
        System.out.printf("\n file.canWrite() : %b ", file.canWrite());
        System.out.printf("\n file.isHidden() : %b ", file.isHidden());
        System.out.println();
    }
   /*
        创建硬盘中对应的文件或文件目录
        public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
        public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
        public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

        删除磁盘中的文件或文件目录
        public boolean delete()：删除文件或者文件夹
        删除注意事项：Java中的删除不走回收站。
    */
   @Test
   public void testMethod2() throws IOException {
       File file = new File("D:\\code\\github\\DayilyCode\\JavaBase\\helloMkdir.txt");
       if (!file.exists()) {
           file.createNewFile();
           System.out.println(" 创建成功 ");
       } else {
           file.delete();
           System.out.println(" 删除成功 ");
       }
   }

    @Test
    public void test7(){
        File file = new File("D:\\code\\github\\DayilyCode\\JavaBase\\helloLetters.txt");
        boolean mkdir = file.mkdir();
        if (mkdir) {
            System.out.println(" 创建成功");
        }
        File file1 = new File("D:\\code\\github\\DayilyCode\\JavaBase\\helloLetters1.txt");
        file1.mkdir();
        file1.delete();
    }
}
