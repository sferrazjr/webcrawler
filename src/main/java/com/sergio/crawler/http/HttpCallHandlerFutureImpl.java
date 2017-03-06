package com.sergio.crawler.http;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.crawler.domain.Site;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpCallHandlerFutureImpl {

    private String content;
    private static boolean done;


    public String getContent() {
        return content;
    }

    public String handleHttpResponseBody(String url) {

//        HttpRequestFutureTask<String> task = futureRequestExecutionService.execute(
//                new HttpGet(url), HttpClientContext.create(),
//                new HttpCallHandler(), new ContentCallback());

        return content;

    }

    public static void main(String[] args) {

        HttpClient httpClient = HttpClientBuilder.create().setMaxConnPerRoute(1).build();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        FutureRequestExecutionService futureRequestExecutionService = new FutureRequestExecutionService(httpClient, executorService);

        List<Site> sites = readJsonFileSite();

        List<HttpRequestFutureTask> futures = new ArrayList<>();

        sites.forEach( site ->  futures.add( futureRequestExecutionService.execute(
                new HttpGet(site.getURL()), HttpClientContext.create(),
                new HttpCallHandler(), new ContentCallback()) ));

        done = false;

        while(!done) {
            futures.forEach(future -> future.isDone());
        }

        System.out.println("oink");

    }

    private void setDone(boolean d){
        done = d;
    }


    private static List<Site> readJsonFileSite() {

        ObjectMapper mapper = new ObjectMapper();

        List<Site> sites = new ArrayList<>();

        try {

            sites = mapper.readValue( new File("/home/sergio/development/java-projects/webcrawler/src/test/resources/sites.json") , new TypeReference<List<Site>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sites;

    }



}