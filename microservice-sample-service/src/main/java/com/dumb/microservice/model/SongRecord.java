package com.dumb.microservice.model;

/**
 * Created by guayu on 7/28/2017.
 */
public class SongRecord {
    private String  name;
    private String  url;
    private String  cover;
    private Boolean isDemo;
    private String  rawUrl;
    private String  Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Boolean getDemo() {
        return isDemo;
    }

    public void setDemo(Boolean demo) {
        isDemo = demo;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
