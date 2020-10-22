package com.demofeng.demo.pac.getContent;

import com.demofeng.demo.pac.connection.ConnectionUtil;
import com.demofeng.demo.pac.file.Output;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author xuefeng
 * @version 1.0.0
 * @ClassName GetContent.java
 * @Description TODO
 * @createTime 2020年09月23日 08:41:00
 */
public class GetContent {
    /**
     * 根据获得的文本找到需要的信息
     * @param document   接受网页内容
     */
    public void getContent(Document document){
        //.text()可得title
        //.attr("href") 可得链接
        String title = "";
        String content = "";
        String url = "";

        //正常模块
        Elements elements = document.select(".result");     //获得非百度百科块
        Elements titles = elements.select(".t");     //得到每块里标题部分
        Elements contents = elements.select(".c-abstract");      //得到每块里内容部分
        int j = 0 ;
        int z = 0 ;
        for (int i = 0;i < elements.size();i++){
            if(j < titles.size()){
                title = titles.get(i).text();
                url = titles.get(i).select("a").attr("href");
                j ++ ;
            }else{
                title = "title没有了哦 ！！！！！！！！！";
            }
            if (z < contents.size() ){
                content = contents.get(i).text();
                z++;
            }else {
                content = "content没有了哦。。。。。。。。。";
            }


            Output.writeU(title,content, url);      //每个都写入文件
        }
        //百度百科模块
        Elements elementsB = document.select("[class=\"result-op c-container xpath-log\"]");  //得到百度百科模块
        Elements titlesB = elementsB.select("[class=\"t c-gap-bottom-small\"]");     //得到每块里标题部分
        for (Element e:titlesB
        ) {
            url = e.select("a").attr("href");
            getContentB(url);
        }
    }


    /**
     * 用来对搜索到的百度百科进行提取
     * @param url
     */
    public void getContentB(String url) {
        Document document = ConnectionUtil.Connect(url);
        Elements titles = document.select("[class=\"lemmaWgt-lemmaTitle-title\"]");
        Elements contents = document.select("[class=\"lemma-summary\"]");
        Elements others = document.select("[class=\"basic-info cmn-clearfix\"]");
        String title = titles.get(0).text();
        String content = contents.get(0).text();
        String other = others.get(0).text();
        Output.writeB(title,content,other);
    }
}
