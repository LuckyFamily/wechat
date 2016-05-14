package com.wechat.po;

import java.util.List;

/**
 * Created by jiangyiming on 5/14/16.
 */
public class NewsMessage extends BaseMessage{
    private int articleCount;
    private List<News> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
