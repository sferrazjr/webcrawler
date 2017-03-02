package com.sergio.crawler.implementation;

import com.sergio.crawler.http.HttpCallHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlerImplementation {

    private HttpCallHandler httpCallHandler = new HttpCallHandler();

    public boolean isUrlReadable(String url){

        String webContent = httpCallHandler.handleHttpResponseBody(url);

        boolean hasNewsInTheTitle = isContainsNewsInTheTitle(webContent);

        return hasNewsInTheTitle;

    }

    private boolean isContainsNewsInTheTitle(String webContent) {
        Document doc = Jsoup.parse(webContent);

        String title = doc.title();

        return title.toUpperCase().contains("NEWS");
    }


}
