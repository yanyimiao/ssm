package com.java;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOTest {

    /**
     * NIO 复制文件测试
     */
    @Test
    public void aboutIO(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("C:\\Users\\jxl\\Desktop\\study\\test.txt"));
            fos = new FileOutputStream(new File("C:\\Users\\jxl\\Desktop\\study\\100.txt"));
            FileChannel readChannel = fis.getChannel(); //读文件通道
            FileChannel writeChannel = fos.getChannel();//写文件通道
            ByteBuffer buffer = ByteBuffer.allocate(1024); // 分配缓冲
            while (true) {
                buffer.clear();  //为读入数据到buffer做准备， 重置标志位
                int len = readChannel.read(buffer); //读入文件
                if(len == -1){
                    System.out.println("读取完毕");
                    break;
                }
                buffer.flip();// 将buffer从读状态转为写状态 重置标志位
                writeChannel.write(buffer); //写入文件
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
