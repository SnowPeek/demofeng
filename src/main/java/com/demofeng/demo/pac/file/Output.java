package com.demofeng.demo.pac.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author xuefeng
 * @version 1.0.0
 * @ClassName Output.java
 * @Description TODO
 * @createTime 2020年09月23日 08:41:00
 */
public class Output {

    public static void writeU(String title,String content,String url){
        String filePath = "C:\\2020\\TEST\\PuTong.txt";   //写入地址
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filePath, true),"utf-8"));
            out.write(title+" | "+ content + " | " + url + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeB(String title,String content,String other){
        String filePath = "C:\\2020\\TEST\\BaiDuBaiKe.txt";   //写入地址
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filePath, true),"utf-8"));
            out.write(title+" | "+ content +" | "+ other + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
