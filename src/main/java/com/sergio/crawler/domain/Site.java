package com.sergio.crawler.domain;

public class Site {


    private String url;
    private boolean readable;

    public Site(String url) {
        this.url = url;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public boolean isReadable() {
        return readable;
    }

    public String getURL() {
        return url;
    }
}
