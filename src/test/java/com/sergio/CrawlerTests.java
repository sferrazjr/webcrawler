package com.sergio;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.crawler.Crawler;
import com.sergio.crawler.domain.Site;
import com.sergio.crawler.http.HttpCallHandlerFutureImpl;
import com.sergio.crawler.implementation.SiteCrawlerImplementation;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by sergio on 3/1/17.
 */
public class CrawlerTests {


    SiteCrawlerImplementation siteCrawler = new SiteCrawlerImplementation();

    HttpCallHandlerFutureImpl callHandlerFuture = new HttpCallHandlerFutureImpl();

    @Test
    public void Site_Should_Be_Readable(){

//        List<Site> sites = readJsonFileSite();
//
//        sites.forEach(
//                site -> callHandlerFuture.myFuture(site.getURL())
//        ) ;

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
