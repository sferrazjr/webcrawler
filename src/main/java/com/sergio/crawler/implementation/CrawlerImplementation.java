package com.sergio.crawler.implementation;

import com.sergio.crawler.domain.Site;
import com.sergio.crawler.http.HttpCallHandler;
import com.sergio.crawler.parser.ContentParser;

import java.io.IOException;

public class CrawlerImplementation {

    private HttpCallHandler httpCallHandler = new HttpCallHandler();
    private ContentParser contentParser = new ContentParser();
    private String webContent;

    public Site parse(String url) {

        Site site = new Site(url);

        try {

            webContent = httpCallHandler.handleHttpResponseBody(url);

            site.setSiteOfNews(isUrlOfNewsSite());

        } catch (IOException e) {
            site.setErrorMessage(e.getMessage());
        }

        return site;
    }


    private boolean isUrlOfNewsSite(){

        return contentParser.isContainsNewsInTheTitle(webContent);

    }

}
