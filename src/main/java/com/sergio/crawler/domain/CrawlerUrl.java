package com.sergio.crawler.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CrawlerUrl {


    private String url;

    public CrawlerUrl() {
    }

    public String getURL() {
        return url;
    }
}
