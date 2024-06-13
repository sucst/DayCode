package cn.atsuc.io;

import org.junit.Test;

import java.io.*;

/**
 * @author atsuc
 * @date 2024/6/10 21:02
 * @email s202011105851@163.com
 * @description
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上。
 */
public class BufferedTest {
    /*
         实现非文本文件的复制
     */
    @Test
    public void BufferedTest01() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("D:\\code\\github\\DayilyCode\\JavaBase\\src\\main\\java\\cn\\atsuc\\io\\random.jpg");
            File destFile = new File("D:\\code\\github\\DayilyCode\\JavaBase\\src\\main\\java\\cn\\atsuc\\io\\loveAndPiece.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream des = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(des);
            //3.复制的细节：读取、写入
            byte[] bytes = new byte[10];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                   bos.close();
                } catch (IOException e) {

                }
            } // if
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }
    // 实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }
    @Test
    public void BufferedTest03() {
        long start = System.currentTimeMillis();
        String srcPath = "F:\\vedio\\第1节 React工程创建和抽奖组件使用.mp4";
        String destPath = "F:\\vedio\\第2节 Mock接口对接抽奖页面.mp4";
        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start));//618 - 176
    }
    /**
        使用BufferedReader和BufferedWriter实现文本文件的复制
    */
    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(new File("D:\\code\\github\\DayilyCode\\JavaBase\\src\\main\\java\\cn\\atsuc\\io\\dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("D:\\code\\github\\DayilyCode\\JavaBase\\src\\main\\java\\cn\\atsuc\\io\\dbcp1.txt")));

            //读写操作
            // 方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null) {
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二
                bw.write(data); //data中不包含换行符
                bw.newLine(); // 提供换行的操作
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            if(bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
