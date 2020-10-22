package com.demofeng.demo.pac.main;

import com.demofeng.demo.pac.connection.ConnectionUtil;
import com.demofeng.demo.pac.file.Input;
import com.demofeng.demo.pac.getContent.GetContent;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author xuefeng
 * @version 1.0.0
 * @ClassName PacMain.java
 * @Description TODO
 * @createTime 2020年09月23日 08:42:00
 */
public class PacMain {
    public static void main(String[] args) throws InterruptedException {
        String filePath = "C:\\2020\\TEST\\searchWords.txt";
        List<String> searchWords = Input.inputTxt(filePath);
        GetContent getContent = new GetContent();
        String url = "";
        for (String word:searchWords) {
           // url = "https://www.baidu.com/s?wd=" + word ;
            int num = 0 ;
            for(num = 0 ; num < 76 ; num  ++ ){
              //  url = "%E9%87%8D%E5%BA%86%E5%85%AC%E5%8F%B8&pn="+String.valueOf(num)+"0&oq=%E9%87%8D%E5%BA%86%E5%85%AC%E5%8F%B8&ie=utf-8&usm=2&rsv_pq=f4a4ac790007cf73&rsv_t=0d5cYZDF0bb1WJ5iY9uSs2RWLUQ1yrXx9990bpuaZbU6sAkBO0Cf7nm2hYA";
              // url ="https://www.baidu.com/s?wd=%E9%87%8D%E5%BA%86%E5%85%AC%E5%8F%B8&pn="+String.valueOf(num)+"0&oq=%E9%87%8D%E5%BA%86%E5%85%AC%E5%8F%B8&ie=utf-8&usm=2&rsv_pq=e1c4cb3a0000de81&rsv_t=1ef2m6ZiSeajgtgI6jC2d%2BUc%2B8nOqPgz10yHPKopnnnpNkHubvcFwu19xKc";
                url = "https://www.baidu.com/s?wd=%E9%87%8D%E5%BA%86%20%E6%B8%B8%E6%88%8F%E5%85%AC%E5%8F%B8&pn="+String.valueOf(num)+"10&oq=%E9%87%8D%E5%BA%86%20%E6%B8%B8%E6%88%8F%E5%85%AC%E5%8F%B8&ie=utf-8&usm=4&rsv_pq=d4ad0ad50004989f&rsv_t=92abmkALGXAFD85N%2Ba1uyrI8X9gBpWRAVoPqTisc3iNQzHJtCYt8FrjoWf8";

                getContent.getContent(ConnectionUtil.Connect(url));
                sleep(1000);
            }

        }
    }
}
