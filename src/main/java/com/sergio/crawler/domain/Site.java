package com.sergio.crawler.domain;

public class Site {


    private String url;
    private boolean siteOfNews;

    public Site(String url) {
        this.url = url;
    }

    public void setSiteOfNews(boolean siteOfNews) {
        this.siteOfNews = siteOfNews;
    }

    public boolean isSiteOfNews() {
        return siteOfNews;
    }

    public String getURL() {
        return url;
    }
}
