package com.sergio;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.crawler.akka.actors.CrawlerActor;
import com.sergio.crawler.akka.actors.CrawlerCallerActor;
import com.sergio.crawler.domain.Site;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlerActorTests {

    @Test
    public void Should_Run_With_Akka_Actors(){

        final ActorSystem system = ActorSystem.create("CrawlerSystem");

        final ActorRef crawlerActorRef = system.actorOf(Props.create(CrawlerActor.class),"crawlerActor");


        List<Site> sites = readJsonFileSite();

        for (Site site : sites) {

            crawlerActorRef.tell(site, ActorRef.noSender());

        }

        System.out.println("Done!!!!!!!");


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
