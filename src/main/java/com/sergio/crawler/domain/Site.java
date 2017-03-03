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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Site{");
        sb.append("url='").append(url).append('\'');
        sb.append(", siteOfNews=").append(siteOfNews);
        sb.append('}');
        return sb.toString();
    }
}
