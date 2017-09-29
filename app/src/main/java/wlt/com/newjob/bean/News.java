package wlt.com.newjob.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/5/9.
 */

public class News extends BmobObject {
    private String news_type;
    private String news_title;
    private String news_time;
    private String news_content;
    private String author;
    private String news_addtime;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNews_addtime() {
        return news_addtime;
    }

    public void setNews_addtime(String news_addtime) {
        this.news_addtime = news_addtime;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }
}
