package com.sergio.crawler.domain;

/**
 * Created by sergio on 3/1/17.
 */
public class Site {


    private String url;
    private boolean readable;
    private String URL;

    public Site(String url) {

    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public boolean isReadable() {
        return readable;
    }

    public String getURL() {
        return URL;
    }
}
