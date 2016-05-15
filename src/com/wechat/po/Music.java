package com.wechat.po;

/**
 * Created by jiangyiming on 5/15/16.
 */
public class Music {
    private String title;
    private String description;
    private String musicUrl;
    private String hqmusicUrl;
    private String thumbMediaId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqmusicUrl() {
        return hqmusicUrl;
    }

    public void setHqmusicUrl(String hqmusicUrl) {
        this.hqmusicUrl = hqmusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
