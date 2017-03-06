package com.sergio;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.crawler.akka.actors.CrawlerActor;
import com.sergio.crawler.domain.CrawlerUrl;
import com.sergio.crawler.domain.Site;

import com.sergio.crawler.implementation.CrawlerImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * Created by sergio on 3/1/17.
 */
public class CrawlerTests {

    private Site site;

    private CrawlerImplementation crawlerImplementation = new CrawlerImplementation();

    @Test
    public void Site_Should_Be_Readable(){

        final ActorSystem system = ActorSystem.create("CrawlerSystem");

        final ActorRef crawlerActorRef = system.actorOf(Props.create(CrawlerActor.class),"crawlerActor");

        List<CrawlerUrl> urls = readJsonFileSite();

        List<Site> sites = new ArrayList<>();

        urls.forEach( url -> sites.add( crawlerImplementation.parse( url.getURL() )));

        Assert.assertThat(sites.size(), is(urls.size()));

    }


    private static List<CrawlerUrl> readJsonFileSite() {

        ObjectMapper mapper = new ObjectMapper();

        List<CrawlerUrl> crawlerUrls = new ArrayList<>();

        try {

            crawlerUrls = mapper.readValue( new File("/home/sergio/development/java-projects/webcrawler/src/test/resources/sites.json") , new TypeReference<List<CrawlerUrl>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return crawlerUrls;

    }

}
