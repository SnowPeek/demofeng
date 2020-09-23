package com.demofeng.demo.pac.connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author xuefeng
 * @version 1.0.0
 * @ClassName ConnectionUtil.java
 * @Description TODO
 * @createTime 2020年09月23日 08:40:00
 */
public class ConnectionUtil {
    /**
     *
     * @param address   //传入地址
     * @return  StringBuffer类全页面内容
     */
    public static Document Connect(String address){
        try {
            Document document = Jsoup.connect(address).get();
            return document;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
