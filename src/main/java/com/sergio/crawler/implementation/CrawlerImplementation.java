package com.sergio.crawler.implementation;

import com.sergio.crawler.http.HttpCallHandler;
import com.sergio.crawler.parser.ContentParser;

public class CrawlerImplementation {

    private HttpCallHandler httpCallHandler = new HttpCallHandler();
    private ContentParser contentParser = new ContentParser();

    public boolean isUrlOfNewsSite(String url){

        String webContent = httpCallHandler.handleHttpResponseBody(url);

        boolean hasNewsInTheTitle = contentParser.isContainsNewsInTheTitle(webContent);

        return hasNewsInTheTitle;

    }


}
