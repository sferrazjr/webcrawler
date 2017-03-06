package com.sergio.crawler.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Site {

    @JsonProperty("url")
    private String url;

    private boolean siteOfNews;

    private String errorMessage;

    public Site() {
    }

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
