package com.demofeng.demo.pac.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuefeng
 * @version 1.0.0
 * @ClassName Input.java
 * @Description TODO
 * @createTime 2020年09月23日 08:40:00
 */
public class Input {
    /**
     * 读取Txt文件
     * @param filePath
     */
    public static List<String> inputTxt(String filePath){
        File file = new File(filePath);
        BufferedReader reader = null;
        String words = "";
        List<String> seachWords = new ArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((words = reader.readLine()) != null) {
                seachWords.add(words);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return seachWords;
    }
}
