package com.sergio;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Assert;

import javax.validation.constraints.AssertTrue;

public class ActorCrawlerTests {


    public void Should_Call_An_Actor(){

        final Config config = ConfigFactory.load();

        final ActorSystem system = ActorSystem.create("CrawlerSystem", config);
            try {

            ActorRef crawlerActor = system.actorOf(CrawlerActor.props(), "crawler");


            Assert.assertTrue(true);

        } catch (Exception e) {
            system.terminate();
            throw e;
        }
    }


}
