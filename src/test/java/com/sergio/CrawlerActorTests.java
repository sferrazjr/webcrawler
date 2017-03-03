package com.sergio;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.sergio.crawler.akka.actors.CrawlerActor;
import com.sergio.crawler.akka.actors.CrawlerCallerActor;
import com.sergio.crawler.domain.Site;
import org.junit.Test;

public class CrawlerActorTests {

    final ActorSystem system = ActorSystem.create("CrawlerSystem");

    Site site = new Site("www.bbc.co.uk/news");

    @Test
    public void Should_Run_With_Akka_Actors(){

        ActorRef crawlerActorRef = system.actorOf(Props.create(CrawlerActor.class),"crawlerActor");

        system.actorOf(CrawlerCallerActor.props(crawlerActorRef, site), "crawlerCallerActor");


    }

}
