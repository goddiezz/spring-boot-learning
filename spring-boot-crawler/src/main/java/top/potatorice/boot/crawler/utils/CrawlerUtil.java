package top.potatorice.boot.crawler.utils;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import top.potatorice.boot.crawler.entity.Rank;

import org.apache.http.HttpEntity;
import
        org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PotatoRice
 * @description：爬虫工具类
 * @date 2021/4/5 4:37 下午
 */


//public class CrawlerUtil {
//    public static final int SUCCESS = 200;
//
//    /**
//     * 爬取b站排行榜数据
//     *
//     * @return List<Rank>
//     */
//    public static List<Rank> getRanks() {
//        List<Rank> ranks = new ArrayList<>();
//        String url = "https://www.bilibili.com/v/popular/rank/all";
//        String userAgent = "Mozilla/5.0 (Linux; Android 6.0;Nexus 5 Build / MRA58N)AppleWebKit / 537.36 (KHTML, like Gecko)Chrome / 89.0 .4389 .90 Mobile Safari/537.36 ";
//        CloseableHttpClient httpClient =
//                HttpClients.createDefault();
//        try {
//            HttpGet httpGet = new HttpGet(url);
//
////设置请求头
//            httpGet.setHeader("user-agent", userAgent);
//            HttpClientContext context =
//                    HttpClientContext.create();
////发起get请求
//            CloseableHttpResponse response =
//                    httpClient.execute(httpGet, context);
//            int statusCode =
//                    response.getStatusLine().getStatusCode();
//            if (statusCode == SUCCESS) {
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    String res = EntityUtils.toString(entity);
////                    System.out.println(res);
//                    Document document = Jsoup.parse(res);
//                    Elements elements = document.getElementsByClass("rank-item");
////                    System.out.println(elements.size());
//                    for (Element element : elements) {
//                        //每个li的内容节点
//                        Element content = element.child(1);
//                        //排行榜标题
//                        String title = content.select(".title").text();
//                        //System.out.println(title); //排行榜地址
//                        String link = "https:" + content.select(".title").attr("href");
////                        System.out.println(content);
//                        //排行榜封面图
//                        String cover = "https:" + content.select(".cover").get(0).attr("src");
//                        Elements detail = content.select(".data-box");
//                        //播放量
//                        String playCount = detail.get(0).text().trim();
//                        //观看量
//                        String viewCount = detail.get(1).text().trim();
//                        //up主
//                        String upName = detail.get(2).text().trim();
//                        //创建Rank对象
//                        Rank rank = Rank.builder()
//                                .upName(upName)
//                                .title(title)
//                                .link(link)
//                                .playCount(playCount)
//                                .viewCount(viewCount)
//                                .cover(cover)
//                                .build();
//                        ranks.add(rank);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ranks;
//    }
public class CrawlerUtil {
    public static final int SUCCESS = 200;

    /**
     * 爬取b站排行榜数据
     *
     * @return List<Rank>
     */
    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        String url = "https://www.zhihu.com/hot";
        String userAgent = "Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Mobile Safari/537.36";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);

//设置请求头
            httpGet.setHeader("user-agent", userAgent);
            HttpClientContext context = HttpClientContext.create();
//发起get请求
            CloseableHttpResponse response = httpClient.execute(httpGet, context);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == SUCCESS) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String res = EntityUtils.toString(entity);
//                    System.out.println(res);
                    Document document = Jsoup.parse(res);
                    Elements elements = document.getElementsByClass("css-hi1lih");
//                    System.out.println(elements);
                    for (Element element : elements) {
                        //每个li的内容节点
                        Element content = element;
                        //排行榜标题
                        String title = content.select(".css-3yucnr").text();
                        //排行榜地址
                        String link = "https:" + content.select(".css-hi1lih").attr("href");
                        //排行榜封面图
                        String cover = "https:" + content.select(".css-uw6cz9").attr("src");
                        //id
                        String id = content.select(".css-qg55th").text().trim();
//                        if (id == null) {
                        String id1 = content.select(".css-1cyth4b").text().trim();
//                        System.out.println(id);
//                        }

                        //简介
                        String content1 = content.select(".css-1o6sw4j").text().trim();
                        //热度
                        String hot = content.select(".css-1ixcu37").text().trim();
                        //创建Rank对象
                        Rank rank = Rank.builder()
                                .id(id + id1)
                                .content1(content1)
                                .title(title)
                                .link(link)
                                .hot(hot)
                                .cover(cover)
                                .build();
                        ranks.add(rank);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ranks;
    }

    public static void main(String[] args) {
        List<Rank> ranks = CrawlerUtil.getRanks();
        ranks.forEach(System.out::println);
    }
}