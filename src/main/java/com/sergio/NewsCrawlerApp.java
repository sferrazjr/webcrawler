package com.sergio;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.crawler.akka.actors.CrawlerActor;
import com.sergio.crawler.domain.Site;
import com.sergio.crawler.domain.CrawlerUrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsCrawlerApp {

    public static void main(String[] args){


        final ActorSystem system = ActorSystem.create("CrawlerSystem");

        final ActorRef crawlerActorRef = system.actorOf(Props.create(CrawlerActor.class),"crawlerActor");

        List<CrawlerUrl> urls = readJsonFileSite();

        for (CrawlerUrl url : urls) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    crawlerActorRef.tell(url, ActorRef.noSender());
                }
            }).start();

        }

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
