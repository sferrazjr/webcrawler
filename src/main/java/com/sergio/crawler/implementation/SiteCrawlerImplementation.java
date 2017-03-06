package com.sergio.crawler.implementation;

import com.sergio.crawler.Crawler;
import com.sergio.crawler.domain.Site;
import com.sergio.crawler.http.HttpCallHandler;
import com.sergio.crawler.http.HttpCallHandlerClientImpl;
import com.sergio.crawler.http.HttpCallHandlerFutureImpl;
import com.sergio.crawler.parser.ContentParser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.FutureRequestExecutionService;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpRequestFutureTask;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SiteCrawlerImplementation {
    //implements } Crawler<Site> {

    private ContentParser contentParser = new ContentParser();

    private String webContent;

    HttpClient httpClient = HttpClientBuilder.create().setMaxConnPerRoute(1).build();

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    FutureRequestExecutionService futureRequestExecutionService = new FutureRequestExecutionService(httpClient, executorService);


    public String parser(String url) {

        futureRequestExecutionService.execute(
                new HttpGet(url), HttpClientContext.create(),
                new HttpCallHandler(), new ContentCallback());


        return webContent;
    }

    public boolean isUrlOfNewsSite(){

        return contentParser.isContainsNewsInTheTitle(webContent);

    }

    public final class ContentCallback implements FutureCallback<String> {

        @Override
        public void completed(String s) {

            webContent = s;

        }

        public void failed(final Exception ex) {
            // do something
        }


        public void cancelled() {
            // do something
        }
    }


}
